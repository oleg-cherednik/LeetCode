/**
 * Given a string <tt>s</tt> consisting of lowercase English letters, return <i>the first letter to appear
 * <b>twice</b></i>.
 * <ul>
 * <b>Note:</b>
 * <li>A letter <tt>a</tt> appears twice before another letter <tt>b</tt> if the <b>second</b> occurrence of <tt>a</tt>
 * is before the <b>second</b> occurrence of <tt>b</tt>.</li>
 * <li><tt>s</tt> will contain at least one letter that appears twice</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "abccbaacz"
 * Output: "c"
 * Explanation:
 * The letter 'a' appears on the indexes 0, 5 and 6.
 * The letter 'b' appears on the indexes 1 and 4.
 * The letter 'c' appears on the indexes 2, 3 and 7.
 * The letter 'z' appears on the index 8.
 * The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second
 * occurrence is the smallest.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "abcdd"
 * Output: "d"
 * Explanation:
 * The only letter that appears twice is 'd' so we return 'd'.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= s.length <= 100</tt></li>
 * <li><tt>s</tt> consists of lowercase English letters.</li>
 * <li><tt>s</tt> has at least one repeated letter.</li>
 * </il>
 *
 * @author Oleg Cherednik
 * @since 04.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(repeatedCharacter("abccbaacz")); // c
        System.out.println(repeatedCharacter("abcdd"));     // d
    }

    public static char repeatedCharacter(String s) {
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int j = ch - 'a';

            letters[j]++;

            if (letters[j] >= 2)
                return ch;
        }

        return '\0';
    }

}
