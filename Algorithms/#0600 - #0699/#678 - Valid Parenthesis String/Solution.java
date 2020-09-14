/**
 * <ol>
 * Given a string containing only three types of characters: <tt>'('</tt>, <tt>')'</tt> and <tt>'*'</tt>, write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 * <li>Any left parenthesis <tt>'('</tt> must have a corresponding right parenthesis <tt>')'</tt>.</li>
 * <li>Any right parenthesis <tt>')'</tt> must have a corresponding left parenthesis <tt>'('</tt>.</li>
 * <li>Left parenthesis <tt>'('</tt> must go before the corresponding right parenthesis <tt>')'</tt>.</li>
 * <li><tt>'*'</tt> could be treated as a single right parenthesis <tt>')'</tt> or a single left parenthesis <tt>'('</tt> or an empty string.</li>
 * <li>An empty string is also valid.</li>
 * </ol>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "()"
 * Output: True
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "(*)"
 * Output: True
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "(*))"
 * Output: True
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The string size will be in the range <tt>[1, 100]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkValidString("()"));     // true
        System.out.println(checkValidString("(*)"));    // true
        System.out.println(checkValidString("(*))"));   // true
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));   // false
        System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));   // true
    }

    public static boolean checkValidString(String s) {
        int count1 = 0;
        int stars1 = 0;
        int count2 = 0;
        int stars2 = 0;

        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            char ch = s.charAt(i);

            if (ch == '*')
                stars1++;
            else if (ch == '(')
                count1++;
            else if (ch == ')') {
                if (count1 > 0)
                    count1--;
                else if (stars1 > 0)
                    stars1--;
                else
                    return false;
            }

            ch = s.charAt(j);

            if (ch == '*')
                stars2++;
            else if (ch == ')')
                count2++;
            else if (ch == '(') {
                if (count2 > 0)
                    count2--;
                else if (stars2 > 0)
                    stars2--;
                else
                    return false;
            }
        }

        return count1 <= stars1 && count2 <= stars2;
    }
}
