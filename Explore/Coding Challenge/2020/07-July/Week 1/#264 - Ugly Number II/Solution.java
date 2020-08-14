/**
 * Write a program to find the <tt>n-th</tt> ugly number.
 * <p>
 * Ugly numbers are <b>positive numbers</b> whose prime factors only include <tt>2, 3, 5</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1</tt> is typically treated as an ugly number.</li>
 * <li><tt>n</tt> <b>does not exceed 1690</b>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 05.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(nthUglyNumber(10));  // 12
    }

    public static int nthUglyNumber(int n) {
        int[] num = { 0, 0, 0, 0, 0, 0 };
        int[] tmp = { 0, 0, 2, 3, 0, 5 };

        int[] arr = new int[n];
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(tmp[5], Math.min(tmp[2], tmp[3]));
            tmp[2] = arr[i] == tmp[2] ? arr[++num[2]] * 2 : tmp[2];
            tmp[3] = arr[i] == tmp[3] ? arr[++num[3]] * 3 : tmp[3];
            tmp[5] = arr[i] == tmp[5] ? arr[++num[5]] * 5 : tmp[5];
        }

        return arr[n - 1];
    }

}
