import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given an array of strings <tt>arr</tt>. A string <tt>s</tt> is formed by the <bb>concatenation</bb> of a
 * <b>subsequence</b> of <tt>arr</tt> that has <b>unique characters</b>.
 * <p>
 * Return <i>the <b>maximum</b> possible length of <tt>s</tt></i>.
 * <p>
 * A <b>subsequence</b> is an array that can be derived from another array by deleting some or no elements without
 * changing the order of the remaining elements.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <pre>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <pre>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <pre>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 16</tt></li>
 * <li><tt>1 <= arr[i].length <= 26</tt></li>
 * <li><tt>arr[i] contains only lowercase English letters</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 25.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxLength(List.of("un", "iq", "ue")));               // 4
        System.out.println(maxLength(List.of("cha", "r", "act", "ers")));       // 6
        System.out.println(maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));   // 26
    }

    public static int maxLength(List<String> arr) {
        List<String> words = getWordsWithUniqueLetters(arr);
        Set<String> concatenations = findUniqueLettersConcatenations(words, 0);

        int res = 0;

        for (String concatenation : concatenations)
            res = Math.max(res, concatenation.length());

        return res;
    }

    private static List<String> getWordsWithUniqueLetters(List<String> arr) {
        List<String> res = new ArrayList<>(arr.size());

        int[] letters = new int[26];

        out:
        for (String str : arr) {
            Arrays.fill(letters, 0);

            for (int i = 0; i < str.length(); i++)
                letters[str.charAt(i) - 'a']++;

            for (int count : letters)
                if (count > 1)
                    continue out;

            res.add(str);
        }

        return res;
    }

    private static Set<String> findUniqueLettersConcatenations(List<String> words, int i) {
        if (i >= words.size())
            return Set.of();

        Set<String> res = new HashSet<>();
        String word = words.get(i);
        res.add(words.get(i));

        for (String suffix : findUniqueLettersConcatenations(words, i + 1)) {
            res.add(suffix);

            if (hasUniqueLetters(word, suffix))
                res.add(word + suffix);
        }

        return res;
    }

    private static boolean hasUniqueLetters(String one, String two) {
        for (int i = 0; i < one.length(); i++)
            if (two.indexOf(one.charAt(i)) >= 0)
                return false;

        return true;
    }
}
