import java.util.Scanner;

/**
 * Using Assignment 01's starter code to discuss standard I/O
 * 
 * @author Jeffrey Bergamini for CMPS 11, jbergami@ucsc.edu
 */
public class Assignment01StarterCode {

  /**
   * For now, just reads whitespace-delimited tokens from standard input (System.in), and prints
   * them back out to standard output (System.out).
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    @SuppressWarnings("resource") // Ignore warning about not closing this Scanner
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
      String token = input.next();
      System.out.println("Found a token: " + token);
    }
  }

}