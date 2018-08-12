package ProjectEuler;

/**
 * <h1>Problem 5</h1>
 *
 * <p>
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.<br>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * LCM(a, b, c) = LCM(LCM(a,b), c).<br>
 * Thus, we just have to nest LCMs for each number in 1,...,20.<br>
 * For that, we can use the relation LCM(a,b) = a*b / GCD(a,b).<br>
 * To get the GCD, we'll use Euclid's algorithm.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem005 {

    public static void main(String[] args) {
        long lcm = 2;
        for (long i = 2; i <= 20; i++) {
            lcm = LCM(i, lcm);
        }
        System.out.println(lcm);
    }

    /**
     * LCM(a,b) * GCD(a,b) = a * b.
     * 
     * @param a
     *            First integer.
     * @param b
     *            Second integer.
     * @return the LCM of a and b.
     */
    public static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }

    /**
     * Euclid's algorithm relies on the fact that
     * GCD(qb + r, b) = GCD(r, b) for r < b.
     * That is, GCD(a, b) = GCD(b, a % b) assuming a > b.
     * <p>
     * Applying this relation recursively, we
     * can arrive at the GCD very quickly, since the
     * closer r is to b in one iteration, the smaller
     * r will be on the next iteration.<br>
     * In the worst case, r is half of b at each iteration,
     * which means that r decays exponentially to the GCD.
     * 
     * @param a
     *            First integer.
     * @param b
     *            Second integer.
     * @return The GCD of a and b.
     */
    public static long GCD(long a, long b) {
        if (b > a) {
            long c = a;
            a = b;
            b = c;
        }
        long r = a % b;
        if (r == 0) return b;
        long s = GCD(b, r);
        if (s == 0) return r;
        return s;
    }
}
