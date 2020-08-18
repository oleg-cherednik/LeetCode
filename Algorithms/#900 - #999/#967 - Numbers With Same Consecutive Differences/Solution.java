import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Return all <b>non-negative</b> integers of length <tt>N</tt> such that the absolute difference between every two
 * consecutive digits is <tt>K</tt>.
 * <p>
 * Note that <b>every</b> number in the answer <b>must not</b> have leading zeros <b>except</b> for the number
 * <tt>0</tt> itself. For example, <tt>01</tt> has one leading zero and is invalid, but <tt>0</tt> is valid.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= N <= 9</tt></li>
 * <li><tt>0 <= K <= 9</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 18.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));  // [181, 292, 707, 818, 929]
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
        // [10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98]
        System.out.println(Arrays.toString(numsSameConsecDiff(1, 0)));  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(numsSameConsecDiff(1, 2)));  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> res = new TreeSet<>();

        for (int i = N > 1 && K > 2 ? 1 : 0; i <= 9; i++)
            numsSameConsecDiff(N, K, i, 1, res);

        return res.stream().mapToInt(i -> i).toArray();
    }

    private static void numsSameConsecDiff(int N, int K, int num, int length, Set<Integer> res) {
        if (length == N) {
            if (String.valueOf(num).length() == N)
                res.add(num);
        } else {
            int lastDigit = num % 10;

            if (lastDigit + K <= 9)
                numsSameConsecDiff(N, K, num * 10 + lastDigit + K, length + 1, res);
            if (lastDigit - K >= 0)
                numsSameConsecDiff(N, K, num * 10 + lastDigit - K, length + 1, res);
        }
    }

}
