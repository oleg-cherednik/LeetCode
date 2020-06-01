/**
 * Given two strings <tt>text1</tt> and <tt>text2</tt>, return the length of their longest common subsequence.
 * <p>
 * A <i>subsequence</i> of a string is a new string generated from the original string with some characters (can be none) deleted without changing
 * the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A <i>common subsequence</i> of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= text1.length <= 1000</tt></li>
 * <li><tt>1 <= text2.length <= 1000</tt></li>
 * <li>The input strings consist of lowercase English characters only.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 26.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));   // 3
        System.out.println(longestCommonSubsequence("abc", "abc"));     // 3
        System.out.println(longestCommonSubsequence("abc", "def"));     // 0
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] arr = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++)
            for (int j = 1; j <= text2.length(); j++)
                arr[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? arr[i - 1][j - 1] + 1 : Math.max(arr[i - 1][j], arr[i][j - 1]);

        return arr[text1.length()][text2.length()];
    }

}
