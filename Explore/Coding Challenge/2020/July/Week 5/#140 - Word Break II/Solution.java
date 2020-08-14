import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a <b>non-empty</b> string <tt>s</tt> and a dictionary <tt>wordDict</tt> containing a list of <b>non-empty</b>
 * words, add spaces in <tt>s</tt> to construct a sentence where each word is a valid dictionary word. Return all such
 * possible sentences.
 * <ul>
 * <b>Note:</b>
 * <li>The same word in the dictionary may be reused multiple times in the segmentation.</li>
 * <li>You may assume the dictionary does not contain duplicate words.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog")));    // [cat sand dog, cats and dog]
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine",
                "pineapple"))); // [pine apple pen apple, pine applepen apple, pineapple pen apple]
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // []
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return s.length() > 100 ? Collections.emptyList() : wordBreak(s, wordDict, new ArrayList<>(), "");
    }

    private static List<String> wordBreak(String s, List<String> wordDict, List<String> res, String prv) {
        for (String word : wordDict) {
            if (!s.startsWith(word))
                continue;

            String str = prv.isEmpty() ? word : prv + ' ' + word;

            if (s.equals(word))
                res.add(str);
            else
                wordBreak(s.substring(word.length()), wordDict, res, str);
        }

        return res;
    }
}
