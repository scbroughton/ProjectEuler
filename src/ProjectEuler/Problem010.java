package ProjectEuler;

/**
 * <h1>Problem 10</h1>
 *
 * <p>
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.<br>
 * Find the sum of all the primes below two million.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * Simple enough. We will borrow the memoization method from {@link ProjectEuler.Problem007} to make our primality tests
 * more efficient.<br>
 * We also estimate the number of primes using the Prime Number Theorem:<br>
 * pi(x) ~ x / ln(x)<br>
 * That is, the number of primes less than x is approximately x / ln(x).
 * <p>
 * In fact, this approximation is quite tight. pi(2M) / (2M/ln(2M)) < 1.1. Thus, allocating 1.1 * 2x10^6 / ln(2x10^6) ~
 * 151,634 will give us sufficient space to hold all of the primes we'll use.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem010 {

    public static void main(String[] args) {
        int bound = (int) Math.floor(1.1 * 2000000 / Math.log(2000000));
        int[] primes = new int[bound];
        long sum = 2;
        primes[0] = 2;
        int latest = 0;
        boolean prime = true;
        for (int i = 3; i < 2000000; i++) {
            prime = true;
            for (int j = 0; j <= latest; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes[++latest] = i;
                sum += i;
            }
        }
        System.out.println(sum);
    }
}