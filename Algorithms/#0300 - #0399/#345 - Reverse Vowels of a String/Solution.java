import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given a string <tt>s</tt>, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are <tt>'a'</tt>, <tt>'e'</tt>, <tt>'i'</tt>, <tt>'o'</tt>, and <tt>'u'</tt>,
 * and they can appear in both cases.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "hello"
 * Output: "holle"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "leetcode"
 * Output: "leotcede"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 3 * 10<sup>5</sup></tt></li>
 * <li><tt>s</tt> consist of <b>printable ASCII</b> characters</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 06.09.2021
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseVowels("hello"));     // holle
        System.out.println(reverseVowels("leetcode"));  // leotcede
        System.out.println(reverseVowels("aA"));        // Aa
        System.out.println(reverseVowels("Ui"));        // iU
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++)
            if (vowels.contains(s.charAt(i)))
                stack.push(s.charAt(i));

        StringBuilder buf = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++)
            buf.append(vowels.contains(s.charAt(i)) ? stack.pop() : s.charAt(i));

        return buf.toString();
    }

}

