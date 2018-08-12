package ProjectEuler;

/**
 * <h1>Problem 1</h1>
 *
 * <p>
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.<br>
 * The sum of these multiples is 23.<br>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * This is a simple mod check.
 *
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem001 {

    public static void main(String[] args) {
        int sum = 0;
        for (int num = 1; num <= 1000; num++)
            if (num % 3 == 0 || num % 5 == 0) sum += num;
        System.out.println(sum);
    }
}
