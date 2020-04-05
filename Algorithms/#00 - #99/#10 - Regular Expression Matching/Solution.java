/**
 * Given an input string (<tt>s</tt>) and a pattern (<tt>p</tt>), implement regular expression matching with support for <tt>'.'</tt> and <tt>'*'</tt>.
 * <p/>
 * <pre>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * </pre>
 * The matching should cover the <b>entire</b> input string (not partial).
 * <ul>
 * <b>Note:</b>
 * <li><tt>s</tt> could be empty and contains only lowercase letters <tt>a-z</tt>.</li>
 * <li><tt>p</tt> could be empty and contains only lowercase letters <tt>a-z</tt>, and characters like <tt>.</tt> or <tt>*</tt>.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isMatch("aa", "a"));                     // false
        System.out.println(isMatch("aa", "a*"));                    // true
        System.out.println(isMatch("ab", ".*"));                    // true
        System.out.println(isMatch("aab", "c*a*b"));                // true
        System.out.println(isMatch("mississippi", "mis*is*p*."));   // false
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;
        char prv = '\0';

        for (int j = 0; j <= p.length(); j++) {
            char ch = p.charAt(j);

            if(prv == '\0')
                prv = ch;
            else if(ch == '.') {


            }
        }

        return i == s.length();
//        return s.matches(p);
    }

}
