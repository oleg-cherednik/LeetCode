import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <ul>
 * Given a sentence <tt>text</tt> (A <i>sentence</i> is a string of space-separated words) in the following format:
 * <li>First letter is in upper case.</li>
 * <li>Each word in <tt>text</tt> are separated by a single space.</li>
 * </ul>
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same
 * length, arrange them in their original order.
 * <p>
 * Return the new text following the format shown above.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: text = "Leetcode is cool"
 * Output: "Is cool leetcode"
 * Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
 * Output is ordered by length and the new first word starts with capital letter.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: text = "Keep calm and code on"
 * Output: "On and keep calm code"
 * Explanation: Output is ordered as follows:
 * "On" 2 letters.
 * "and" 3 letters.
 * "keep" 4 letters in case of tie order by position in original text.
 * "calm" 4 letters.
 * "code" 4 letters.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: text = "To be or not to be"
 * Output: "To be or to be not"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>text</tt> begins with a capital letter and then contains lowercase letters and single space between words.</li>
 * <li><tt>1 <= text.length <= 10<sup>5</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(arrangeWords("Leetcode is cool"));       // Is cool leetcode
        System.out.println(arrangeWords("Keep calm and code on"));  // On and keep calm code
        System.out.println(arrangeWords("To be or not to be"));     // To be or to be not
    }

    public static String arrangeWords(String text) {
        class Data {

            final int pos;
            final String word;

            public Data(int pos, String word) {
                this.pos = pos;
                this.word = word;
            }
        }

        String[] words = text.toLowerCase().split("\\s");
        String str = IntStream.range(0, words.length)
                              .mapToObj(i -> new Data(i, words[i]))
                              .sorted(Comparator.comparing((Function<Data, Integer>)data -> data.word.length()).thenComparingInt(one -> one.pos))
                              .map(data -> data.word)
                              .collect(Collectors.joining(" "));
        return str.length() <= 1 ? str.toUpperCase() : Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
