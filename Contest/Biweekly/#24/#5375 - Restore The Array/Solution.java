/**
 * A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits and
 * all we know is that all integers in the array were in the range <tt>[1, k]</tt> and there are no leading zeros in the array.
 * <p>
 * Given the string <tt>s</tt> and the integer <tt>k</tt>. There can be multiple ways to restore the array.
 * <p>
 * Return <i>the number of possible array</i> that can be printed as a string <tt>s</tt> using the mentioned program.
 * <p>
 * The number of ways could be very large so return it <b>modulo</b> <tt>10<sup>9</sup> + 7</tt>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "1000", k = 10000
 * Output: 1
 * Explanation: The only possible array is [1000]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "1000", k = 10
 * Output: 0
 * Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "1317", k = 2000
 * Output: 8
 * Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: s = "2020", k = 30
 * Output: 1
 * Explanation: The only possible array is [20,20]. [2020] is invalid because 2020 > 30. [2,020] is ivalid because 020 contains leading zeros.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: s = "1234567890", k = 90
 * Output: 34
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 10^5</tt>.</li>
 * <li><tt>s</tt> consists of only digits and doesn't contain leading zeros.</li>
 * <li><tt>1 <= k <= 10<sup>9</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numberOfArrays("1000", 10000));      // 1
        System.out.println(numberOfArrays("1000", 10));         // 0
        System.out.println(numberOfArrays("1317", 2000));       // 8
        System.out.println(numberOfArrays("2020", 30));         // 1
        System.out.println(numberOfArrays("1234567890", 90));   // 34
        // TODO time limit exceeded on big input
    }

    public static int numberOfArrays(String s, int k) {
        int[] res = new int[1];
        numberOfArrays(s, k, 0, 1, res);
        return res[0];
    }

    private static boolean numberOfArrays(String s, int k, int i, int j, int[] count) {
        if (i >= s.length())
            return true;

        while (true) {
            int val = j > s.length() ? 0 : Integer.parseInt(s.substring(i, j));

            if (val < 1 || val > k)
                return false;

            int[] c = new int[1];

            if (numberOfArrays(s, k, j, j + 1, c))
                count[0] += c[0] + 1;
            else
                count[0] += c[0];

            count[0] %= 100000000007L;
            j++;
        }
    }
}
