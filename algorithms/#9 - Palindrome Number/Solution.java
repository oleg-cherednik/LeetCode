/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 121
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * </pre>
 * <p>
 * <b>Follow up:</b><br>
 * Could you solve it without converting the integer to a string?
 *
 * @author Oleg Cherednik
 * @since 22.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int val = x;
        int tmp = 0;

        while (x > 0) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }

        return tmp == val;
    }

}
