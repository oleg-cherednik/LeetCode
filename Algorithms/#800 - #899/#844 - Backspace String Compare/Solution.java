/**
 * Given two strings <tt>S</tt> and <tt>T</tt>, return if they are equal when both are typed into empty text editors. <tt>#</tt> means a backspace
 * character.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= S.length <= 200</tt></li>
 * <li><tt>1 <= T.length <= 200</tt></li>
 * <li><tt>S</tt> and <tt>T</tt> only contain lowercase letters and <tt>'#'</tt> characters.</li>
 * </ol>
 * <ul>
 * <b>Follow up:</b>
 * <li>Can you solve it in <tt>O(N)</tt> time and <tt>O(1)</tt> space?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 09.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));           // true
        System.out.println(backspaceCompare("ab##", "c#d#"));           // true
        System.out.println(backspaceCompare("a##c", "#a#c"));           // true
        System.out.println(backspaceCompare("a#c", "b"));               // false
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));   // true
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));    // false
    }

    public static boolean backspaceCompare(String S, String T) {
        for (int is = S.length() - 1, it = T.length() - 1, cs = 0, ct = 0; is >= 0 || it >= 0; ) {
            char chs = is >= 0 ? S.charAt(is) : '\0';
            char cht = it >= 0 ? T.charAt(it) : '\0';

            if (is >= 0 && (chs == '#' || cs > 0)) {
                cs = chs == '#' ? cs + 1 : cs - 1;
                is--;
                continue;
            }

            if (it >= 0 && (cht == '#' || ct > 0)) {
                ct = cht == '#' ? ct + 1 : ct - 1;
                it--;
                continue;
            }

            if (is < 0 || it < 0 || chs != cht)
                return false;

            is--;
            it--;
        }

        return true;
    }
}
