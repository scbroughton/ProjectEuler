package ProjectEuler;

/**
 * <h1>Problem 3</h1>
 *
 * <p>
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.<br>
 * What is the largest prime factor of the number 600851475143?
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * A simple factorization algorithm. We add a little efficiency by lowering the upper-bound of the loop after each
 * division.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem003 {

    public static void main(String[] args) {
        long num = 600851475143l;
        long sqrt = (long) Math.ceil(Math.sqrt(num));
        for (long i = 2l; i < sqrt; i++)
            if (num % i == 0) {
                num /= i;
                sqrt = (long) Math.ceil(Math.sqrt(num));
                i--;
            }
        System.out.println(num);
    }

}
