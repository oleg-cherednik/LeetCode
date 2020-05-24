/**
 * Given a <tt>sentence</tt> that consists of some words separated by a <b>single space</b>, and a <tt>searchWord</tt>.
 * <p>
 * You have to check if <tt>searchWord</tt> is a prefix of any word in <tt>sentence</tt>.
 * <p>
 * Return <i>the index of the word</i> in <tt>sentence</tt> where <tt>searchWord</tt> is a prefix of this word (<b>1-indexed</b>).
 * <p>
 * If <tt>searchWord</tt> is a prefix of more than one word, return the index of the first word (<b>minimum index</b>). If there is no such word
 * return <b>-1</b>.
 * <p>
 * A <b>prefix</b> of a string <tt>S</tt> is any leading contiguous substring of <tt>S</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: sentence = "i am tired", searchWord = "you"
 * Output: -1
 * Explanation: "you" is not a prefix of any word in the sentence.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: sentence = "i use triple pillow", searchWord = "pill"
 * Output: 4
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: sentence = "hello from the other side", searchWord = "they"
 * Output: -1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= sentence.length <= 100</tt></li>
 * <li><tt>1 <= searchWord.length <= 10</tt></li>
 * <li><tt>sentence</tt> consists of lowercase English letters and spaces.</li>
 * <li><tt>searchWord</tt> consists of lowercase English letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));             // 4
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));   // 2
        System.out.println(isPrefixOfWord("i am tired", "you"));                        // -1
        System.out.println(isPrefixOfWord("i use triple pillow", "pill"));              // 4
        System.out.println(isPrefixOfWord("hello from the other side", "they"));        // -1
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++)
            if (words[i].startsWith(searchWord))
                return i + 1;

        return -1;
    }
}
