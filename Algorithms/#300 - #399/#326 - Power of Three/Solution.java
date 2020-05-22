/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 27
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 0
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 9
 * Output: true
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: 45
 * Output: false
 * </pre>
 * <b>Follow up:</b><br>
 * Could you do it without using any loop / recursion?
 *
 * @author Oleg Cherednik
 * @since 22.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPowerOfThree(27));     // true
        System.out.println(isPowerOfThree(0));      // false
        System.out.println(isPowerOfThree(9));      // true
        System.out.println(isPowerOfThree(124));    // false
        System.out.println(isPowerOfThree(45));     // false
        System.out.println(isPowerOfThree(1));      // true
        System.out.println(isPowerOfThree(243));    // true
    }

    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

}
