import java.util.Scanner;

/**
 * Let's make some exceptions happen.
 * 
 * @author Jeffrey Bergamini for CMPS 11, jbergami@ucsc.edu
 */
public class ExceptionThrower {

  /**
   * How *not* to use a Scanner, etc.
   * 
   * @param args maybe some command-line arguments?
   */
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner stdin = new Scanner(System.in);
    while (stdin.hasNext()) {
      int number = stdin.nextInt(); // May throw an exception if token not interpretable as int
      System.out.printf("2^%d = %f", number, Math.pow(2, number));
    }
    // Going out of an array's bounds will throw an exception
    System.out.println("The first command-line argument was: " + args[0]);
  }

}