import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a <b>non-empty</b> string <tt>s</tt> and a dictionary <tt>wordDict</tt> containing a list of <b>non-empty</b> words, determine if <tt>s</tt>
 * can be segmented into a space-separated sequence of one or more dictionary words.
 * <ul>
 * <b>Note:</b>
 * <li>The same word in the dictionary may be reused multiple times in the segmentation.</li>
 * <li>You may assume the dictionary does not contain duplicate words.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 29.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));                       // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));                  // true
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))); // false
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    private static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (s.isEmpty())
            return true;
        if (map.containsKey(s))
            return map.get(s);

        for (String word : wordDict) {
            if (!s.startsWith(word))
                continue;
            if (!wordBreak(s.substring(word.length()), wordDict, map))
                continue;
            map.put(s, true);
            return true;
        }

        map.put(s, false);
        return false;
    }
}
