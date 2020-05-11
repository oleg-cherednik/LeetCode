import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string containing digits from <tt>2-9</tt> inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <img src="200px-Telephone-keypad2.svg.png" />
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 * <b>Note:</b>
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(letterCombinations("23"));   // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    public static List<String> letterCombinations(String digits) {
        return new ArrayList<>(letterCombinations(0, digits, new LinkedList<>()));
    }

    private static Queue<String> letterCombinations(int i, String digits, Queue<String> queue) {
        if (i >= digits.length())
            return queue;

        char[] letters = getLetters(digits.charAt(i));

        if (letters == null)
            queue.clear();
        else {
            if (queue.isEmpty()) {
                for (char letter : letters)
                    queue.add(String.valueOf(letter));
            } else {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    String str = queue.remove();

                    for (char letter : letters)
                        queue.add(str + letter);
                }
            }

            letterCombinations(i + 1, digits, queue);
        }

        return queue;
    }

    private static char[] getLetters(char ch) {
        if (ch == '2')
            return new char[] { 'a', 'b', 'c' };
        if (ch == '3')
            return new char[] { 'd', 'e', 'f' };
        if (ch == '4')
            return new char[] { 'g', 'h', 'i' };
        if (ch == '5')
            return new char[] { 'j', 'k', 'l' };
        if (ch == '6')
            return new char[] { 'm', 'n', 'o' };
        if (ch == '7')
            return new char[] { 'p', 'q', 'r', 's' };
        if (ch == '8')
            return new char[] { 't', 'u', 'v' };
        if (ch == '9')
            return new char[] { 'w', 'x', 'y', 'z' };
        return null;
    }
}
