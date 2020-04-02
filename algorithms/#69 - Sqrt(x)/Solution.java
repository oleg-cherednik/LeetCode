/**
 * Implement <tt>int sqrt(int x)</tt>.
 * <p>
 * Compute and return the square root of <tt>x</tt>, where <tt>x</tt> is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 4
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(mySqrt(90));  // 9
        System.out.println(mySqrt(4));  // 2
        System.out.println(mySqrt(8));  // 2
        System.out.println(mySqrt(0));  // 0
        System.out.println(mySqrt(1));  // 1
        System.out.println(mySqrt(2));  // 1
        System.out.println(mySqrt(2147395599)); // 46339
        System.out.println(mySqrt(2147483647)); // 46340

    }

    public static int mySqrt(int x) {
        return mySqrt(x, 0, x);
    }

    private static int mySqrt(int x, long i, long j) {
        if (i + 1 >= j)
            return j * j <= x ? (int)j : (int)i;

        long m = (i + j) / 2;

        if (m * m == x)
            return (int)m;
        if (m * m > x)
            return mySqrt(x, i, (int)m);
        return mySqrt(x, (int)m, j);
    }

}
