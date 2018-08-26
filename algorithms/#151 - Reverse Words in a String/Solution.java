/**
 * Given an input string, reverse the string word by word.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * </pre>
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>A word is defined as a sequence of non-space characters.</li>
 * <li>Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.</li>
 * <li>You need to reduce multiple spaces between two words to a single space in the reversed string.</li>
 * </ul>
 * <p>
 * <b>Follow up:</b> For C programmers, try to solve it in-place in O(1) space.
 *
 * @author Oleg Cherednik
 * @since 26.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder buf = new StringBuilder(s.length());

        for (int i = words.length - 1; i >= 0; i--)
            buf.append(' ').append(words[i]);

        return buf.toString().trim();
    }

}
