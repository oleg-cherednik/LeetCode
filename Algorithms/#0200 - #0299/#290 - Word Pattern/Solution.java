import java.util.HashMap;
import java.util.Map;

/**
 * Given a <tt>pattern</tt> and a string <tt>str</tt>, find if <tt>str</tt> follows the same <tt>pattern</tt>.
 * <p>
 * Here <b>follow</b> means a full match, such that there is a bijection between a letter in <tt>pattern</tt> and a <b>non-empty</b> word in
 * <tt>str</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * </pre>
 * <b>Notes:</b>
 * <p>
 * You may assume <tt>pattern</tt> contains only lowercase letters, and <tt>str</tt> contains lowercase letters that may be separated by a single
 * space.
 *
 * @author Oleg Cherednik
 * @since 07.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));     // true
        System.out.println(wordPattern("abba", "dog cat cat fish"));    // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));     // false
        System.out.println(wordPattern("abba", "dog dog dog dog"));     // false
        System.out.println(wordPattern("aaa", "aa aa aa aa"));          // false
        System.out.println(wordPattern("jquery", "jquery"));            // false
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> chMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        String[] words = str.split("\\s+");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);

            if (chMap.containsKey(ch)) {
                if (!chMap.get(ch).equals(word))
                    return false;
            } else if (wordMap.containsKey(word))
                return false;

            chMap.put(ch, word);
            wordMap.put(word, ch);
        }

        return true;
    }
}
