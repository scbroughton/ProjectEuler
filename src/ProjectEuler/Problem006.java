package ProjectEuler;

/**
 * <h1>Problem 6</h1>
 *
 * <p>
 *
 * The sum of the squares of the first ten natural numbers is<br>
 * 1^2 + 2^2 + ... + 10^2 = 385.<br>
 * The square of the sum of the first ten natural numbers is<br>
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025<br>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 - 385 = 2640.<br>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the
 * sum.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * While this could be done iteratively, we can make use of the formulas<br>
 * 1 + ... + n = n(n+1)/2<br>
 * and<br>
 * 1^2 + ... + n^2 = n(n+1)(2n+1)/6.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem006 {

    public static void main(String[] args) {
        int n = 100;
        System.out.println((int) Math.pow((double) n * (n + 1) / 2,
                                          2) - n * (n + 1) * (2 * n + 1) / 6);
    }
}