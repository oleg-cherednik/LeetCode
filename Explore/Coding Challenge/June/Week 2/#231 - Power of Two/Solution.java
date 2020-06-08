/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 218
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 20.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPowerOfTwo(1));            // true
        System.out.println(isPowerOfTwo(16));           // true
        System.out.println(isPowerOfTwo(218));          // false
        System.out.println(isPowerOfTwo(0x80000000));   // false
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

}
