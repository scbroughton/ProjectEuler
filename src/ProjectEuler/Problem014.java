package ProjectEuler;

/**
 * <h1>Problem 14</h1>
 *
 * <p>
 *
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
 * proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 12, 2018
 */

public class Problem014 {

    public static void main(String[] args) {
        int longestStart = 1;
        int longestCount = 0;
        for (int i = 2; i < 1000000; i++) {
            int count = 0;
            for (long n = i; n > 1; count++)
                n = collatz(n);
            if (count > longestCount) {
                longestStart = i;
                longestCount = count;
            }
        }
        System.out.println(longestStart + " " + longestCount);
    }

    public static long collatz(long n) {
        if (n % 2 == 0) return n / 2;
        return 3 * n + 1;
    }
}