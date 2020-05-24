/**
 * Given a string <tt>s</tt> and an integer <tt>k</tt>.
 * <p>
 * Return the <i>maximum number of vowel letters</i> in any substring of <tt>s</tt> with length <tt>k</tt>.
 * <p>
 * <b>Vowel letters</b> in English are (a, e, i, o, u).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: s = "tryhard", k = 4
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 10<sup>5</sup></tt></li>
 * <li><tt>s</tt> consists of lowercase English letters.</li>
 * <li><tt>1 <= k <= s.length</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxVowels("abciiidef", 3));  // 3
        System.out.println(maxVowels("aeiou", 2));      // 2
        System.out.println(maxVowels("leetcode", 3));   // 2
        System.out.println(maxVowels("rhythms", 4));    // 0
        System.out.println(maxVowels("tryhard", 4));    // 1
    }

    public static int maxVowels(String s, int k) {
        int res = 0;

        for (int i = 0, j = 0, vowels = 0; j < s.length(); j++) {
            if (isVowel(s, j))
                vowels++;

            if (j - i + 1 > k) {
                if (isVowel(s, i))
                    vowels--;
                i++;
            }

            res = Math.max(res, vowels);
        }

        return res;
    }

    private static boolean isVowel(String s, int i) {
        char ch = s.charAt(i);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
