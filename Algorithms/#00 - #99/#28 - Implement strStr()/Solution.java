/**
 * Implement <tt>strStr()</tt>.
 * <p>
 * Return the index of the first occurrence of needle in haystack, or <b>-1</b> if needle is not part of haystack.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * </pre>
 * <b>Clarification:</b>
 * <p>
 * What should we return when <tt>needle</tt> is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return <b>0</b> when <tt>needle</tt> is an empty <tt>string</tt>. This is consistent to C's
 * <tt>strstr()</tt> and Java's <tt>indexOf()</tt>.
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(strStr("hello", "ll"));  // 2
        System.out.println(strStr("aaaaa", "bba")); // -1
        System.out.println(strStr("a", "a")); // 0
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null || needle.isEmpty())
            return 0;

        out:
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++)
                if (haystack.charAt(i + j) != needle.charAt(j))
                    continue out;

            return i;
        }

        return -1;
    }

}
