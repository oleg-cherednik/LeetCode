import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters <t>'('</t>, <t>')'</t>, <t>'{'</t>, <t>'}'</t>, <t>'['</t> and <t>']'</t>, determine if the input
 * string is valid.
 * <p>
 * An input string is valid if:
 * <ul>
 * <li>Open brackets must be closed by the same type of brackets.</li>
 * <li>Open brackets must be closed in the correct order.</li>
 * </ul>
 * Note that an empty string is also considered valid.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "()"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "()[]{}"
 * Output: true
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "(]"
 * Output: false
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: "([)]"
 * Output: false
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: "{[]}"
 * Output: true
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.01.2019
 */
public class Solution {

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                stack.add(ch);
            else {
                if (stack.isEmpty())
                    return false;

                char prv = stack.removeLast();

                if (ch == ')' && prv != '(')
                    return false;
                if (ch == '}' && prv != '{')
                    return false;
                if (ch == ']' && prv != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String... args) {
        System.out.println(isValid("()"));  // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));  // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
    }

}
