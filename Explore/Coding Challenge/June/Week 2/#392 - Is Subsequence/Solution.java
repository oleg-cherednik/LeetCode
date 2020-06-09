/**
 * Given a string <tt>s</tt> and a string <tt>t</tt>, check if <tt>s</tt> is subsequence of <tt>t</tt>.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (ie, <tt>"ace"</tt> is a subsequence of <tt>"abcde"</tt> while <tt>"aec"</tt> is
 * not).
 * <p>
 * <b>Follow up:</b>
 * <p>
 * If there are lots of incoming <tt>S</tt>, say <tt>S1, S2, ... , Sk</tt> where <tt>k >= 1B</tt>, and you want to check one by one to see if T has
 * its subsequence. In this scenario, how would you change your code?
 * <p>
 * <b>Credits:</b>
 * <p>
 * Special thanks to <a href="https://leetcode.com/pbrother/">@pbrother</a> for adding this problem and creating all test cases.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= s.length <= 100</tt></li>
 * <li><tt>0 <= t.length <= 10<sup>4</sup></tt></li>
 * <li>Both strings consists only of lowercase characters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 09.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc"));    // true
    }

    public static boolean isSubsequence(String s, String t) {
        boolean res = s.isEmpty();

        for (int i = 0, j = 0; j < t.length() && !res; j++) {
            if (s.charAt(i) != t.charAt(j))
                continue;

            if (i == s.length() - 1)
                res = true;
            else
                i++;
        }

        return res;
    }

}
