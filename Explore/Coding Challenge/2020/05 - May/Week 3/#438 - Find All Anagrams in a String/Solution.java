import java.util.ArrayList;
import java.util.List;

/**
 * Given a string <tt>s</tt> and a <b>non-empty</b> string <tt>p</tt>, find all the start indices of <tt>p</tt>'s anagrams in <tt>s</tt>.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings <tt>s</tt> and <tt>p</tt> will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s: "abab" p: "ab"
 * Output: [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));  // [0, 6]
        System.out.println(findAnagrams("abab", "ab"));         // [0, 1, 2]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] expected = histogram(p);
        int[] actual = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            int length = j - i + 1;
            actual[s.charAt(j) - 'a']++;

            if (length < p.length())
                continue;
            if (length > p.length())
                actual[s.charAt(i++) - 'a']--;
            if (isEquals(expected, actual))
                res.add(i);
        }

        return res;
    }

    private static boolean isEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++)
            if (expected[i] != actual[i])
                return false;

        return true;
    }

    private static int[] histogram(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 'a']++;

        return arr;
    }

}
