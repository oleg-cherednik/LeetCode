/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 16
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 5
 * Output: false
 * </pre>
 * <b>Follow up:</b> Could you solve it without loops/recursion?
 *
 * @author Oleg Cherednik
 * @since 04.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPowerOfFour(0));           // false
        System.out.println(isPowerOfFour(1));           // true
        System.out.println(isPowerOfFour(16));          // true
        System.out.println(isPowerOfFour(5));           // false
        System.out.println(isPowerOfFour(4194304));     // true
        System.out.println(isPowerOfFour(-2147483648)); // false
    }

    public static boolean isPowerOfFour(int num) {
        return (num & num - 1) == 0 && (num | 0x55555555) == 0x55555555 && num != 0;
    }
}
