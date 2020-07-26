/**
 * Given a non-negative integer <tt>num</tt>, repeatedly add all its digits until the result has only one digit.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * </pre>
 * <b>Follow up:</b>
 * <p>
 * Could you do it without any loop/recursion in <tt>O(1)</tt> runtime?
 *
 * @author Oleg Cherednik
 * @since 26.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(addDigits(38));  // 2
        System.out.println(addDigits(0));   // 0
        System.out.println(addDigits(9));   // 9
    }

    public static int addDigits(int num) {
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        return num % 9;
    }

}
