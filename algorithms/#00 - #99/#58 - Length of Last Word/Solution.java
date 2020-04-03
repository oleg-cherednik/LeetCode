/**
 * Given a string <tt>s</tt> consists of upper/lower-case alphabets and empty space characters <tt>' '</tt>, return the length of last word (last word
 * means the last appearing word if we loop from left to right) in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * <b>Note:</b> A word is defined as a <b>maximal substring</b> consisting of non-space characters only.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: "Hello World"
 * Output: 5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(lengthOfLastWord("Hello World"));    // 5
        System.out.println(lengthOfLastWord("a "));             // 1
        System.out.println(lengthOfLastWord("a"));              // 1
        System.out.println(lengthOfLastWord("    day"));        // 3
    }

    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        s = s.trim();

        if (s.isEmpty())
            return 0;

        int pos = s.lastIndexOf(' ');
        return pos == -1 ? s.length() : s.length() - pos - 1;
    }
}
