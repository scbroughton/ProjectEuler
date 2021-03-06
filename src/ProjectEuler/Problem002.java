package ProjectEuler;

/**
 * <h1>Problem 2</h1>
 *
 * <p>
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.<br>
 * By starting with 1 and 2, the first 10 terms will be:<br>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...<br>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the
 * even-valued terms.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * Again, we have a mod check, but now with the complication of Fibonacci numbers. Since we must visit each Fibonacci
 * number, the iterative algorithm will be faster than the recursive one.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem002 {

    public static void main(String[] args) {
        int sum = 0;
        int newN = 1;
        int oldN = 1;
        int cache = 1;
        while (newN <= 4000000) {
            if (newN % 2 == 0) sum += newN;
            cache = newN;
            newN += oldN;
            oldN = cache;
        }
        System.out.println(sum);
    }
}
