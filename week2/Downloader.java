import java.io.FileOutputStream;
import java.net.URL;
 
/**
 * Class Downloader illustrates some aspects of exception handling.
 * 
 * @author Jeffrey Bergamini for CMPS 11, jbergami@ucsc.edu
 */
public class Downloader {
 
  /**
   * Downloads the content served by URL's to appropriate-ish file names, similar to wget.
   * 
   * @param the URL's containing the desired content
   */
  public static void main(String[] urlStrings) {
    // "Enhanced" for loop: For each value in urlStrings, call it urlString...
    for (String urlString : urlStrings) {
      try {
        URL url = new URL(urlString);
        downloadContents(url);
      } catch (Exception e) {
        System.err.println("Bad URL: " + e.getMessage());
      }
    }
  }
 
  /**
   * Downloads the content served by a URL to an appropriate-ish file name.
   * 
   * @param url the URL to download
   */
  private static void downloadContents(URL url) {
 
    try {
      // Make sure the world thinks we're a real browser!
      // (Otherwise many sites will reject our requests.)
      var connection = url.openConnection();
      connection.setRequestProperty("User-Agent",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:66.0) Gecko/20100101 Firefox/66.0");
      // try-with-resources: InputStream will be automatically closed when done
      try (var input = connection.getInputStream()) {
        byte[] contents = input.readAllBytes(); // easy but inefficient
        saveToFile(contents, url);
      }
    } catch (Exception e) {
      System.err.println("Error downloading from URL: " + e.getMessage());
    }
  }
 
  /**
   * Saves bytes to a file named after a URL
   * 
   * @param contents the data to save
   * @param url the URL from which to generate the filename
   * @throws Exception if an I/O error occurs
   */
  private static void saveToFile(byte[] contents, URL url) throws Exception {
    String filename;
    String[] pathComponents = url.getPath().split("/");
    // Decide on file name. Maybe the last component of the URL path?...
    if (pathComponents.length > 0 && pathComponents[pathComponents.length - 1].length() > 0)
      filename = pathComponents[pathComponents.length - 1];
    // ...or, instead, just a modification of the URL itself
    else
      filename = url.getHost() + url.getPath().replaceAll("/", ".");
    // Save contents to file
    try (FileOutputStream output = new FileOutputStream(filename)) {
      output.write(contents);
      System.out.printf("%s: Saved %d bytes to file '%s'%n", url, contents.length, filename);
    }
  }
 
}
