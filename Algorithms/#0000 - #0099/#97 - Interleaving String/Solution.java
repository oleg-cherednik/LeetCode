/**
 * Given strings <tt>s1</tt>, <tt>s2</tt>, and <tt>s3</tt>, find whether <tt>s3</tt>
 * is formed by an <b>interleaving</b> of <tt>s1</tt> and <tt>s2</tt>.
 * <p>
 * An <b>interleaving</b> of two strings <tt>s</tt> and <tt>t</tt> is a configuration
 * where they are divided into <b>non-empty</b> substrings such that:
 * <ui>
 * <li><tt>s = s<sub>1</sub> + s<sub>2</sub> + ... + s<sub>n</sub></tt></li>
 * <li><tt>t = t<sub>1</sub> + t<sub>2</sub> + ... + t<sub>m</sub></tt></li>
 * <li><tt>|n - m| <= 1</tt></li>
 * <li>The <b>interleaving</b> is <tt>s<sub>1</sub> + t<sub>1</sub> + s<sub>2</sub> +
 * t<sub>2</sub> + s<sub>3</sub> + t<sub>3</sub> + ...</tt> or <tt>t<sub>1</sub> +
 * s<sub>1</sub> + t<sub>2</sub> + s<sub>2</sub> + t<sub>3</sub> + s3 + ...</tt></li>
 * </ui>
 * <b>Note:</b> <tt>a + b</tt> is the concatenation of strings <tt>a</tt> and <tt>b</tt>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="interleave.jpg" />
 * <pre>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * </pre>
 * <p>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= s1.length</tt>, <tt>s2.length <= 100</tt></li>
 * <li><tt>0 <= s3.length <= 200</tt></li>
 * <li><tt>s<sub>1</sub></tt>, <tt>s<sub>2</sub></tt>, and <tt>s<sub>3</sub></tt>
 * consist of lowercase English letters.</li>
 * </ul>
 * <p>
 * <b>Follow up:</b> Could you solve it using only <tt>O(s2.length)</tt> additional
 * memory space?
 *
 * @author Oleg Cherednik
 * @since 29.09.2021
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));    // true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));    // false
        System.out.println(isInterleave("", "", ""));    // true
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        return isMatchLetterCount(s1, s2, s3) && isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private static boolean isMatchLetterCount(String s1, String s2, String s3) {
        int[] letters = new int[26];

        for (int i = 0; i < s1.length(); i++)
            letters[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++)
            letters[s2.charAt(i) - 'a']++;
        for (int i = 0; i < s3.length(); i++)
            letters[s3.charAt(i) - 'a']--;

        for (int letterCount : letters)
            if (letterCount != 0)
                return false;

        return true;
    }

    private static boolean isInterleave(String s1, int i, String s2, int j, String s3, int k) {
        if (k >= s3.length())
            return i == s1.length() && j == s2.length();

        boolean res = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res = isInterleave(s1, i + 1, s2, j, s3, k + 1);
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res = isInterleave(s1, i, s2, j + 1, s3, k + 1);

        return res;
    }

}
