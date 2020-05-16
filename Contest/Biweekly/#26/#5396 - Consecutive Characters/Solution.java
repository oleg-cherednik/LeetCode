/**
 * Given a string <tt>s</tt>, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * <p>
 * Return <i>the power</i> of the string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "triplepillooooow"
 * Output: 5
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: s = "tourist"
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 500</tt></li>
 * <li><tt>s</tt> contains only lowercase English letters</li>
 * </il>
 *
 * @author Oleg Cherednik
 * @since 16.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxPower("leetcode"));               // 2
        System.out.println(maxPower("abbcccddddeeeeedcba"));    // 5
        System.out.println(maxPower("triplepillooooow"));       // 5
        System.out.println(maxPower("hooraaaaaaaaaaay"));       // 11
        System.out.println(maxPower("tourist"));                // 1
    }

    public static int maxPower(String s) {
        int res = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            i = s.charAt(i) == s.charAt(j) ? i : j;
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
