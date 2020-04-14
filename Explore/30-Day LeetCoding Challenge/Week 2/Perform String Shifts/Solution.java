/**
 * <ul>
 * You are given a string <tt>s</tt> containing lowercase English letters, and a matrix <tt>shift</tt>, where <tt>shift[i] = [direction, amount]</tt>:
 * <li><tt>direction</tt> can be <tt>0</tt> (for left shift) or <tt>1</tt> (for right shift).</li>
 * <li><tt>amount</tt> is the amount by which string <tt>s</tt> is to be shifted.</li>
 * <li>A left shift by 1 means remove the first character of <tt>s</tt> and append it to the end.</li>
 * <li>Similarly, a right shift by <tt>1</tt> means remove the last character of <tt>s</tt> and add it to the beginning.</li>
 * </ul>
 * Return the final string after all operations.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * </pre>
 * <ul>
 * Constraints:
 * <li><tt>1 <= s.length <= 100</tt></li>
 * <li><tt>s</tt> only contains lower case English letters.</li>
 * <li><tt>1 <= shift.length <= 100</tt></li>
 * <li><tt>shift[i].length == 2</tt></li>
 * <li><tt>0 <= shift[i][0] <= 1</tt></li>
 * <li><tt>0 <= shift[i][1] <= 100</tt></li>
 * </ul>>
 *
 * @author Oleg Cherednik
 * @since 14.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));                         // cab
        System.out.println(stringShift("abcdefg", new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } })); // efgabcd
    }

    public static String stringShift(String s, int[][] shift) {
        int offs = 0;

        for (int[] row : shift)
            offs += row[0] == 0 ? -row[1] : row[1];

        offs %= s.length();

        if (offs == 0)
            return s;

        StringBuilder buf = new StringBuilder(s.length());
        int mid = offs > 0 ? s.length() - offs : -offs;

        for (int i = mid; i < s.length(); i++)
            buf.append(s.charAt(i));
        for (int i = 0; i < mid; i++)
            buf.append(s.charAt(i));

        return buf.toString();
    }
}
