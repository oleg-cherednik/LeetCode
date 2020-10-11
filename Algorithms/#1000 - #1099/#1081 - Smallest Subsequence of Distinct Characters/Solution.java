/**
 * Return the lexicographically smallest subsequence of <tt>s</tt> that contains all the distinct characters of <tt>s</tt> exactly once.
 * <p>
 * <b>Note:</b> This question is the same as <a href="https://leetcode.com/problems/remove-duplicate-letters/">316</a>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "bcabc"
 * Output: "abc"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 1000</tt></li>
 * <li><tt>s</tt> consists of lowercase English letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 11.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(smallestSubsequence("bcabc"));       // abc
        System.out.println(smallestSubsequence("cbacdcbc"));    // acdb
    }

    public static String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] exists = new boolean[26];
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            count[ch - 'a']--;

            if (exists[ch - 'a'])
                continue;

            while (buf.length() > 0 && buf.charAt(buf.length() - 1) > ch && count[buf.charAt(buf.length() - 1) - 'a'] > 0) {
                exists[buf.charAt(buf.length() - 1) - 'a'] = false;
                buf.deleteCharAt(buf.length() - 1);
            }

            buf.append(ch);
            exists[ch - 'a'] = true;
        }

        return buf.toString();
    }

}
