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
        int two = 0;
        int three = 0;
        int five = 0;

        int tmpTwo = 2;
        int tmpThree = 3;
        int tmpFive = 5;

        int[] a = new int[n];
        a[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = tmpTwo > tmpThree ? Math.min(tmpFive, tmpThree) : Math.min(tmpFive, tmpTwo);

            if (a[i] == tmpTwo)
                tmpTwo = a[++two] * 2;
            if (a[i] == tmpThree)
                tmpThree = a[++three] * 3;
            if (a[i] == tmpFive)
                tmpFive = a[++five] * 5;
        }

        return a[n - 1];
    }

}
