/**
 * Given a positive integer <tt>num</tt>, write a function which returns <tt>True</tt> if <tt>num</tt> is a perfect square else <tt>False</tt>.
 * <p>
 * <b>Note: Do not</b> use any built-in library function such as <tt>sqrt</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 16
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 14
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPerfectSquare(16));            // true
        System.out.println(isPerfectSquare(14));            // false
        System.out.println(isPerfectSquare(2147483647));    // false
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = sqrt(num, 0, num);
        return sqrt * sqrt == num;
    }

    private static int sqrt(int x, long i, long j) {
        if (i + 1 >= j)
            return j * j <= x ? (int)j : (int)i;

        long m = (i + j) / 2;

        if (m * m == x)
            return (int)m;
        if (m * m > x)
            return sqrt(x, i, (int)m);
        return sqrt(x, (int)m, j);
    }
}
