import java.util.Arrays;

/**
 * Given two strings <tt>s</tt> and <tt>t</tt>, return <tt>true</tt> <i>if <tt>t</tt> is an anagram of <tt>s</tt>, and
 * <tt>false</tt> otherwise</i>.
 * <p>
 * An <b>Anagram</b> is a word or phrase formed by rearranging the letters of a different word or phrase, typically
 * using all the original letters exactly once.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "rat", t = "car"
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraint:</b>
 * <li><tt>1 <= s.length</tt>, <tt>t.length <= 5 * 10<sup>4</sup></tt></li>
 * <li><tt><tt>s</tt> and <tt>t</tt> consist of lowercase English letters</li>
 * </ul>
 * <p>
 * <b>Follow up:</b> What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 * @author Oleg Cherednik
 * @since 03.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isAnagram("anagram", "nagaram"));    // true
        System.out.println(isAnagram("rat", "car"));            // false
    }

    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++)
            letters[t.charAt(i) - 'a']--;

        for (int count : letters)
            if (count != 0)
                return false;

        return true;
    }
}
