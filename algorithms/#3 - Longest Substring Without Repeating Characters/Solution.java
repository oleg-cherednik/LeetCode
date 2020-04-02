import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 01.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(lengthOfLongestSubstring("abc"));    // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));  // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring(""));       // 0
        System.out.println(lengthOfLongestSubstring("a"));      // 1
        System.out.println(lengthOfLongestSubstring(null));     // 0
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);

        int res = 1;

        for (int i = 0, j = 1; j < s.length(); ) {
            char ch = s.charAt(j);

            if (map.getOrDefault(ch, 0) > 0)
                map.compute(s.charAt(i++), (key, count) -> Optional.ofNullable(count).orElse(0) - 1);

            else {
                map.compute(ch, (key, count) -> Optional.ofNullable(count).orElse(0) + 1);
                res = Math.max(res, j++ - i + 1);
            }
        }

        return res;
    }
}
