import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters <tt>'('</tt> and <tt>')'</tt>,
 * return <i>the length of the longest valid (well-formed) parentheses
 * substring.</i>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = ""
 * Output: 0
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= s.length <= 3 * 10<sup>4</sup></tt></li>
 * <li><tt>s[i]</tt> is <tt>'('</tt>, or <tt>')'</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.08.2025
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses("")); // 0
        System.out.println(longestValidParentheses("()(()"));   // 2
    }

    public static int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(')
                stack.push(i);
            else if (ch == ')' && !stack.isEmpty()) {
                int open = stack.pop();
                arr[open] = i;
                arr[i] = -open;
            }
        }

        int res = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                j += 2;
                res = Math.max(res, j);
            } else if (arr[i] == Integer.MAX_VALUE)
                j = 0;
        }

        return res;
    }

}
