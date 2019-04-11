/**
 * We can demonstrate that CPU's can execute billions of instructions per second!
 * 
 * @author Jeffrey Bergamini for CMPS 11, jbergami@ucsc.edu
 */
public class CpuSpeed {

  /**
   * Prints an estimate of how many operations per second our system can perform.
   * 
   * @param args unused (no command-line arguments for this program)
   */
  public static void main(String[] args) {
    long operationCount = 0;
    long before = System.nanoTime();
    while (operationCount < 5_000_000_000L)  // 5B times, we compare ...
      ++operationCount;                      // ... and increment (i.e. add and assign)
    long after = System.nanoTime();
    System.out.printf("~%.2e operations/second%n", 3.0 * operationCount / (after - before) * 1e9);
  }

}