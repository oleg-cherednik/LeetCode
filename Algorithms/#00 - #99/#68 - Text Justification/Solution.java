import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of words and a width <tt>maxWidth</tt>, format the text such that each line has exactly <tt>maxWidth</tt> characters and is fully
 * (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces <tt>' '</tt> when necessary
 * so that each line has exactly <tt>maxWidth</tt> characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the
 * empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no <b>extra</b> space is inserted between words.
 * <ul>
 * <b>Note:</b>
 * <li>A word is defined as a character sequence consisting of non-space characters only.</li>
 * <li>Each word's length is guaranteed to be greater than 0 and not exceed <tt>maxWidth</tt>.</li>
 * <li>The input array <tt>words</tt> contains at least one word.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
        // [
        //   "This    is    an",
        //   "example  of text",
        //   "justification.  "
        // ]
        System.out.println(fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16));
        // [
        //   "What   must   be",
        //   "acknowledgment  ",
        //   "shall be        "
        // ]
        System.out.println(fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20));
        // [
        //   "Science  is  what we",
        //   "understand      well",
        //   "enough to explain to",
        //   "a  computer.  Art is",
        //   "everything  else  we",
        //   "do                  "]
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();

        List<String> lineWords = new LinkedList<>();
        int wordsWidth = 0;

        for (String word : words) {
            if (wordsWidth + word.length() + lineWords.size() - 1 >= maxWidth) {
                res.add(buildLineStr(lineWords, wordsWidth, maxWidth));
                lineWords.clear();
                wordsWidth = 0;
            }

            lineWords.add(word);
            wordsWidth += word.length();
        }

        if (!lineWords.isEmpty())
            res.add(buildLastLineStr(lineWords, maxWidth));

        return res;
    }

    private static String buildLastLineStr(List<String> words, int maxWidth) {
        StringBuilder buf = new StringBuilder(maxWidth);

        for (String word : words) {
            if (buf.length() != 0)
                buf.append(' ');
            buf.append(word);
        }

        while (buf.length() < maxWidth) {
            buf.append(' ');
        }

        return buf.toString();
    }

    private static String buildLineStr(List<String> words, int wordsWidth, int maxWidth) {
        int[] spaces = new int[words.size() == 1 ? 1 : words.size() - 1];

        while (wordsWidth < maxWidth) {
            for (int i = 0; i < spaces.length && wordsWidth < maxWidth; i++, wordsWidth++)
                spaces[i]++;
        }

        int i = 0;
        StringBuilder buf = new StringBuilder(maxWidth);

        for (String word : words) {
            buf.append(word);

            if (i < spaces.length) {
                for (int j = 0; j < spaces[i]; j++)
                    buf.append(' ');

                i++;
            }
        }

        return buf.toString();
    }

}
