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
        String[] letters = { null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        return new ArrayList<>(letterCombinations(0, digits, letters, new LinkedList<>()));
    }

    private static Queue<String> letterCombinations(int i, String digits, String[] letters, Queue<String> queue) {
        if (i >= digits.length())
            return queue;

        String let = letters[digits.charAt(i) - '0'];

        if (let == null)
            queue.clear();
        else {
            if (queue.isEmpty()) {
                for (int j = 0; j < let.length(); j++)
                    queue.add(String.valueOf(let.charAt(j)));
            } else {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    String str = queue.remove();

                    for (int k = 0; k < let.length(); k++)
                        queue.add(str + let.charAt(k));
                }
            }

            letterCombinations(i + 1, digits, letters, queue);
        }

        return queue;
    }
}
