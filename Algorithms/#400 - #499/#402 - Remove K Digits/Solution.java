import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a non-negative integer <tt>num</tt> represented as a string, remove <tt>k</tt> digits from the number so that the new number is the smallest
 * possible.
 * <ul>
 * <b>Note:</b>
 * <li>The length of <tt>num</tt> is less than 10002 and will be <tt>≥ k</tt>.</li>
 * <li>The given <tt>num</tt> does not contain any leading zero.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 13.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(removeKdigits("1432219", 3));    // 1219
        System.out.println(removeKdigits("10200", 1));      // 200
        System.out.println(removeKdigits("10", 2));         // 0
        System.out.println(removeKdigits("10", 1));         // 0
        System.out.println(removeKdigits("112", 1));        // 11
    }

    public static String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        if (k >= num.length())
            return "0";

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!deque.isEmpty() && k > 0 && deque.element() > ch) {
                deque.pop();
                k--;
            }

            deque.push(ch);
        }

        for (int i = 0; i < k; i++)
            deque.pop();

        int size = deque.size();
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char ch = deque.removeLast();

            if (ch != '0' || buf.length() != 0)
                buf.append(ch);
        }

        return buf.length() == 0 ? "0" : buf.toString();
    }

}
