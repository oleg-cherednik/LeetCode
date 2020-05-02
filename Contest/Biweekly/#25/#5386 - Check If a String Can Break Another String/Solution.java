import java.util.Arrays;

/**
 * Given two strings: <tt>s1</tt> and <tt>s2</tt> with the same size, check if some permutation of string <tt>s1</tt> can break some permutation of
 * string <tt>s2</tt> or vice-versa (in other words <tt>s2</tt> can break <tt>s1</tt>).
 * <p>
 * A string <tt>x</tt> can break string <tt>y</tt> (both of size <tt>n</tt>) if <tt>x[i] >= y[i]</tt> (in alphabetical order) for all <tt>i</tt>
 * between <tt>0</tt> and <tt>n-1</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s1 = "abc", s2 = "xya"
 * Output: true
 * Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s1 = "abe", s2 = "acd"
 * Output: false
 * Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba" and all permutation for s2="acd" are: "acd", "adc",
 * "cad", "cda", "dac" and "dca". However, there is not any permutation from s1 which can break some permutation from s2 and vice-versa.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s1 = "leetcodee", s2 = "interview"
 * Output: true
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>s1.length == n</tt></li>
 * <li><tt>s2.length == n</tt></li>
 * <li><tt>1 <= n <= 10<sup>5</sup></tt></li>
 * <li>All strings consist of lowercase English letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkIfCanBreak("abc", "xya"));  // true
        System.out.println(checkIfCanBreak("abe", "acd"));  // false
        System.out.println(checkIfCanBreak("leetcodee", "interview"));  // true
        System.out.println(checkIfCanBreak("szy", "cid"));  // true
    }

    public static boolean checkIfCanBreak(String s1, String s2) {
        s1 = sortLetters(s1);
        s2 = sortLetters(s2);
        return isBreaks(s1, s2) || isBreaks(s2, s1);
    }

    private static String sortLetters(String str) {
        char[] letters = str.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    private static boolean isBreaks(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) < s2.charAt(i))
                return false;

        return true;
    }
}
