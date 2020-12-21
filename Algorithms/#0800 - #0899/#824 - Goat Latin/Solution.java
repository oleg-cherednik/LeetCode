import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A sentence <tt>S</tt> is given, composed of words separated by spaces. Each word consists of lowercase and uppercase
 * letters only.
 * <p>
 * We would like to convert the sentence to <i>"Goat Latin"</i> (a made-up language similar to Pig Latin.)
 * <ul>
 * The rules of Goat Latin are as follows:
 * <li>If a word begins with a vowel (<tt>a</tt>, <tt>e</tt>, <tt>i</tt>, <tt>o</tt>, or <tt>u</tt>), append <tt>"ma"</tt>
 * to the end of the word.
 * <p>
 * For example, the word <tt>'apple'</tt> becomes <tt>'applema'</tt>.</li>
 * <li>If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
 * <tt>"ma"</tt>.
 * <p>
 * For example, the word <tt>"goat"</tt> becomes <tt>"oatgma"</tt>.</li>
 * <li>Add one letter <tt>'a'</tt> to the end of each word per its word index in the sentence, starting with <tt>1</tt>.
 * <p>
 * For example, the first word gets <tt>"a"</tt> added to the end, the second word gets <tt>"aa"</tt> added to the end
 * and so on.</li>
 * </ul>
 * Return the final sentence representing the conversion from <tt>S</tt> to Goat Latin.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa
 * ogdmaaaaaaaaaa"
 * </pre>
 * <ul>
 * Notes:
 * <li><tt>S</tt> contains only uppercase, lowercase and spaces. Exactly one space between each word.</li>
 * <li><tt>1 <= S.length <= 150</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));  // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
    }

    public static String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String[] words = S.split("\\s+");
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (buf.length() > 0)
                buf.append(' ');

            String word = words[i];
            char ch = word.charAt(0);

            if (vowels.contains(ch))
                buf.append(word);
            else
                buf.append(word.substring(1)).append(ch);

            buf.append("ma");
            repeat('a', i + 1, buf);
        }

        return buf.toString();
    }

    private static void repeat(char ch, int total, StringBuilder buf) {
        for (int i = 0; i < total; i++)
            buf.append(ch);
    }

}
