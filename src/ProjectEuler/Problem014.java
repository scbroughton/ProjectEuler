package ProjectEuler;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

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
    private static final Hashtable<Long,Integer> CACHE = new Hashtable<>();
    private static final int UPPER_BOUND = 1000000;

    public static void main(String[] args) {
        long longestStart = 1;
        int longestCount = 0;
        int count;
        
        System.out.println("-----------Memoized-----------");
        long startTime = System.currentTimeMillis();
        CACHE.put(1l, 0);
        for (Long n = 2l; n < UPPER_BOUND; n++) {
            CACHE.put(n, getHops(n));
            count = CACHE.get(n);
            if (count > longestCount) {
                longestStart = n;
                longestCount = count;
            }
        }
        System.out.println("Time taken:\t\t" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Longest chain's index:\t" + longestStart);
        System.out.println("Chain Length:\t\t" + longestCount);
        System.out.println("Cached Entries:\t\t" + CACHE.size());
        CACHE.clear();
        
        System.out.println("\n-----Direct (w/ Objects)------");
        startTime = System.currentTimeMillis();
        for (Long n = 2l; n < UPPER_BOUND; n++) {
            count = 0;
            for (Long i = n; i != 1; i = collatzObj(i)) count++;
            if (count > longestCount) {
                longestStart = n;
                longestCount = count;
            }
        }
        System.out.println("Time taken:\t\t" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Longest chain's index:\t" + longestStart);
        System.out.println("Chain Length:\t\t" + longestCount);

        System.out.println("\n----Direct (w/ Primitives)----");
        startTime = System.currentTimeMillis();
        for (long n = 2l; n < UPPER_BOUND; n++) {
            count = 0;
            for (long i = n; i != 1; i = collatzPrim(i)) count++;
            if (count > longestCount) {
                longestStart = n;
                longestCount = count;
            }
        }
        System.out.println("Time taken:\t\t" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Longest chain's index:\t" + longestStart);
        System.out.println("Chain Length:\t\t" + longestCount);
    }
    
    private static Integer getHops(Long n) {
        if (!CACHE.containsKey(n)) CACHE.put(n, getHops(collatzObj(n)));
        return CACHE.get(n) + 1;
    }

    private static Long collatzObj(Long n) {
        if (n % 2 == 0) return Long.valueOf(n / 2);
        return Long.valueOf(3 * n + 1);
    }
    
    private static long collatzPrim(long n) {
        if (n % 2 == 0) return n / 2;
        return 3 * n + 1;
    }
}