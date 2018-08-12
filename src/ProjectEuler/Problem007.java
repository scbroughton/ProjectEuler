package ProjectEuler;

/**
 * <h1>Problem 7</h1>
 *
 * <p>
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.<br>
 * What is the 10,001st prime number?
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * This looks like a job for memoization.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem007 {

    public static void main(String[] args) {
        int[] primes = new int[10001];
        primes[0] = 2;
        int latest = 0;
        boolean prime = true;
        for (int i = 3; latest < 10000; i++) {
            prime = true;
            for (int j = 0; j <= latest; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) primes[++latest] = i;
        }
        System.out.println(primes[10000]);
    }
}