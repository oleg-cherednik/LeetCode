import java.util.Arrays;

/**
 * <ul>
 * A <b>happy string</b> is a string that:
 * <li>consists only of letters of the set <tt>['a', 'b', 'c']</tt>.</li>
 * <li><tt>s[i] != s[i + 1]</tt> for all values of <tt>i</tt> from <tt>1</tt> to <tt>s.length - 1</tt> (string is 1-indexed).</li>
 * </ul>
 * For example, strings <b>"abc"</b>, <b>"ac"</b>, <b>"b"</b> and <b>"abcbabcbcb"</b> are all happy strings and strings <b>"aa"</b>, <b>"baa"</b> and
 * <b>"ababbc"</b> are not happy strings.
 * <p>
 * Given two integers <tt>n</tt> and <tt>k</tt>, consider a list of all happy strings of length <tt>n</tt> sorted in lexicographical order.
 * <p>
 * Return <i>the k<sub>th</sub> string</i> of this list or return an <b>empty string</b> if there are less than <tt>k</tt> happy strings of length
 * <tt>n</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 1, k = 4
 * Output: ""
 * Explanation: There are only 3 happy strings of length 1.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"].
 * You will find the 9th string = "cab"
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 2, k = 7
 * Output: ""
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: n = 10, k = 100
 * Output: "abacbabacb"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 10</tt></li>
 * <li><tt>1 <= k <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getHappyString(1, 3));   // "c"
        System.out.println(getHappyString(1, 4));   // ""
        System.out.println(getHappyString(3, 9));   // "cab"
        System.out.println(getHappyString(2, 7));   // ""
        System.out.println(getHappyString(10, 100));   // "abacbabacb"
    }

    public static String getHappyString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        boolean next = false;

        while (k >= 1) {
            if (next)
                if (!next(arr))
                    return "";

            next = true;

            if (isHappyString(arr))
                k--;
        }

        return new String(arr);
    }

    private static boolean isHappyString(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == arr[i + 1])
                return false;
        return true;
    }

    private static boolean next(char[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 'c') {
                if (i == 0)
                    return false;
                arr[i] = 'a';
            } else {
                arr[i]++;
                return true;
            }
        }

        return false;
    }
}
