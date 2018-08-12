package ProjectEuler;

/**
 * <h1>Problem 9</h1>
 *
 * <p>
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,<br>
 * a^2 + b^2 = c^2<br>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.<br>
 * Find the product abc.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * For this problem, we can make use of Euclid's Formula:
 * <p>
 * Let m and n be coprime integers. Then<br>
 * a = m^2 - n^2, b = 2mn, c = m^2 + n^2<br>
 * is a Pythagorean triplet.
 * <p>
 * In particular, the unique pairs (n,m) define the Pythagorean primitives, that is, the Pythagorean triplets such that
 * a, b, and c are mutually coprime.<br>
 * The total set of Pythagorean triplets can be generated from the primitives by multiplying any primitive (a,b,c) by an
 * arbitrary integer k.
 * <p>
 * Note, we are seeking a triplet with the property a + b + c = 1000.<br>
 * Applying Euclid's general formula (and assuming (a,b,c) is a primitive triplet), this equation simplifies to<br>
 * m^2 + mn - 500 = 0.<br>
 * We can thus use the quadratic formula to find m as a function of n, reducing the problem by a dimension:<br>
 * m = (-n + sqrt(n^2 + 2000)) / 2.<br>
 * (Here, we've assumed the positive root.)
 * <p>
 * Since m is an integer, we must have that the denominator is even, thus n and the square root have the same
 * parity.<br>
 * We can also note that n^2 + 2000 must be a square number. In fact, if n^2 + 2000 = s^2, then (s+n)(s-n) = 2000.<br>
 * In particular, s-n < sqrt(2000) < 45.
 * <p>
 * This leads to our method of attack: We initialize s to 45 and decrement as we search for an n that satisfies the
 * above.<br>
 * Once s and n are found, we calculate m by m = (-n + s) / 2.<br>
 * <p>
 * Finally, note that abc = (m^2 - n^2)(2mn)(m^2 + n^2) = 2nm^5 - 2mn^5.<br>
 * If we reuse s for m, we only need to initialize two variables to solve this problem.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem009 {

    public static void main(String[] args) {
        int n = 0, s = 45;
        boolean found = false;
        for (; s > 0; s--) {
            for (n = 0; n < s; n++)
                if ( (s + n) * (s - n) == 2000) {
                    found = true;
                    break;
                }
            if (found) break;
        }
        s = (s - n) / 2;
        System.out.println(2 * (n * (long) Math.pow(s, 5) - s * (long) Math.pow(n, 5)));
    }
}