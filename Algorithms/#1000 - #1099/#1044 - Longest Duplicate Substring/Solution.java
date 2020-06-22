import java.util.HashSet;
import java.util.Set;

/**
 * Given a string <tt>S</tt>, consider all <i>duplicated substrings</i>: (contiguous) substrings of <tt>S</tt> that occur 2 or more times.  (The
 * occurrences may overlap.)
 * <p>
 * Return <b>any</b> duplicated substring that has the longest possible length. (If <tt>S</tt> does not have a duplicated substring, the answer is
 * <tt>""</tt>.)
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "banana"
 * Output: "ana"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "abcd"
 * Output: ""
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>2 <= S.length <= 10<sup>5</sup></tt></li>
 * <li><tt>S</tt> consists of lowercase English letters.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 19.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestDupSubstring("banana"));  // "ana"
        System.out.println(longestDupSubstring("abcd"));    // ""
    }

    public static String longestDupSubstring(String S) {
        int lo = 1;
        int hi = S.length();

        while (lo != hi) {
            int mi = (lo + hi) / 2;

            if (possible(S, mi) != -1)
                lo = mi + 1;
            else
                hi = mi;
        }

        int start = possible(S, lo - 1);
        return start == -1 ? "" : S.substring(start, start + lo - 1);
    }

    private static int possible(String S, int length) {
        final long mod = (long)Math.pow(2, 32);
        long hash = 0;

        for (int i = 0; i < length; ++i)
            hash = (hash * 26 + (S.charAt(i) - 'a')) % mod;

        Set<Long> set = new HashSet<>();
        set.add(hash);

        long global = 1;

        for (int i = 0; i < length; ++i)
            global = (global * 26) % mod;

        for (int start = 1; start < S.length() - length + 1; ++start) {
            hash = (hash * 26 - (S.charAt(start - 1) - 'a') * global % mod + mod) % mod;
            hash = (hash + (S.charAt(start + length - 1) - 'a')) % mod;

            if (set.contains(hash))
                return start;

            set.add(hash);
        }

        return -1;
    }

}
