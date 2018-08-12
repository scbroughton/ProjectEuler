package ProjectEuler;

/**
 * <h1>Problem 4</h1>
 *
 * <p>
 *
 * A palindromic number reads the same both ways.<br>
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.<br>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * <hr>
 * 
 * <h2>Notes:</h2>
 * Since we're looking for the largest palindrome, we start the search from the largest product of 3-digit numbers
 * possible and decrease this number until we find it. Not many other shortcuts we could take here.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 5, 2018
 */
public class Problem004 {

    public static void main(String[] args) {
        for (int i = 999 * 999; i > 0; i--) {
            System.out.println(i);
            boolean palindrome = true;
            String num = Integer.toString(i);
            int l = num.length();
            for (int j = 0; j < l / 2; j++)
                if (num.charAt(j) != num.charAt(l - j - 1)) {
                    palindrome = false;
                    break;
                }
            if (palindrome) for (int j = 999; j > 99; j--)
                if (i % j == 0 && Integer.toString(i / j).length() == 3) {
                    System.out.println("Largest: " + i);
                    System.exit(0);
                }
        }

    }

}
