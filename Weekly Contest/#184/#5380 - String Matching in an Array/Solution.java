import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of string <tt>words</tt>. Return all strings in <tt>words</tt> which is substring of another word in <b>any</b> order.
 * <p>
 * String <tt>words[i]</tt> is substring of <tt>words[j]</tt>, if can be obtained removing some characters to left and/or right side of
 * <tt>words[j]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: words = ["blue","green","bu"]
 * Output: []
 * </pre>
 * <ul>
 * Constraints:
 * <li><tt>1 <= words.length <= 100</tt></li>
 * <li><tt>1 <= words[i].length <= 30</tt></li>
 * <li><tt>words[i]</tt> contains only lowercase English letters.</li>
 * <li>It's <b>guaranteed</b> that <tt>words[i]</tt> will be unique.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.04.2020
 */
public class Solution {

    public static void main(String... args) {
        stringMatchingAndPrint("mass", "as", "hero", "superhero");
        stringMatchingAndPrint("leetcode", "et", "code");
        stringMatchingAndPrint("blue", "green", "bu");
        stringMatchingAndPrint("leetcoder", "leetcode", "od", "hamlet", "am");  // ["leetcode","od","am"]
    }

    private static void stringMatchingAndPrint(String... words) {
        List<String> res = stringMatching(words);
        System.out.println(res.stream().collect(Collectors.joining(",", "[", "]")));
    }

    public static List<String> stringMatching(String[] words) {
        words = Arrays.stream(words).sorted(Comparator.comparingInt(String::length).thenComparing(one -> one)).toArray(String[]::new);

        List<String> res = new ArrayList<>();

        for (int i = 0, size = res.size(); i < words.length; i++, size = res.size())
            for (int j = i + 1; j < words.length && res.size() == size; j++)
                if (words[j].contains(words[i]))
                    res.add(words[i]);

        return res;
    }
}
