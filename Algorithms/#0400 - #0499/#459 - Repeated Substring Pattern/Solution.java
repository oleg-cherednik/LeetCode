import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You
 * may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "aba"
 * Output: False
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(repeatedSubstringPattern("abab"));           // true
        System.out.println(repeatedSubstringPattern("aba"));            // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));   // true
    }

    public static boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i != 0)
                continue;

            Set<String> set = new HashSet<>();

            for (int j = 0; j < s.length(); j += i)
                set.add(s.substring(j, j + i));
            if (set.size() == 1)
                return true;
        }

        return false;
    }

}
