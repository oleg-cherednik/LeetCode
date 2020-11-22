import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: <tt>"a"</tt> maps to
 * <tt>".-"</tt>, <tt>"b"</tt> maps to <tt>"-..."</tt>, <tt>"c"</tt> maps to <tt>"-.-."</tt>, and so on.
 * <p>
 * For convenience, the full table for the <tt>26</tt> letters of the English alphabet is given below:
 * <pre>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
 *  "-.--","--.."]
 * </pre>
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, <tt>"cab"</tt> can be
 * written as <tt>"-.-..--..."</tt>, (which is the concatenation <tt>"-.-." + ".-" + "-..."</tt>). We'll call such a concatenation, the transformation
 * of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The length of words will be at most <tt>100</tt>.</li>
 * <li>Each <tt>words[i]</tt> will have length in range <tt>[1, 12]</tt>.</li>
 * <li><tt>words[i]</tt> will only consist of lowercase letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));    // 2
    }

    private static final String[] LETTERS = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

    public static int uniqueMorseRepresentations(String[] words) {
        return Arrays.stream(words)
                     .map(Solution::convert)
                     .collect(Collectors.toSet()).size();
    }

    private static String convert(String word) {
        return IntStream.range(0, word.length())
                        .mapToObj(word::charAt)
                        .map(ch -> LETTERS[ch - 'a'])
                        .collect(Collectors.joining());
    }

}
