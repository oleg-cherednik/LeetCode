import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings <tt>s</tt> and <tt>t</tt>, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in <tt>s</tt> can be replaced to get <tt>t</tt>.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the
 * same character but a character may map to itself.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "egg", t = "add"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "foo", t = "bar"
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "paper", t = "title"
 * Output: true
 * </pre>
 * <b>Note:</b><br>
 * You may assume both <tt>s</tt> and <tt>t</tt> have the same length.
 *
 * @author Oleg Cherednik
 * @since 22.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isIsomorphic("egg", "add"));     // true
        System.out.println(isIsomorphic("foo", "bar"));     // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("aba", "baa"));     // false
        System.out.println(isIsomorphic("ab", "aa"));       // false
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (map1.containsKey(cs)) {
                if (map1.get(cs) != ct)
                    return false;
            } else if (map2.containsKey(ct)) {
                if (map2.get(ct) != cs)
                    return false;
            } else {
                map1.put(cs, ct);
                map2.put(ct, cs);
            }

            buf.append(ct);
        }

        return buf.toString().equals(t);
    }

}
