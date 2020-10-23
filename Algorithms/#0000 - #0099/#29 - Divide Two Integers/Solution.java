/**
 * Given two integers <tt>dividend</tt> and <tt>divisor</tt>, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing <tt>dividend</tt> by <tt>divisor</tt>.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, <tt>truncate(8.345) = 8</tt> and
 * <tt>truncate(-2.7335) = -2</tt>.
 * <ul>
 * <b>Note:</b>
 * <li>Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: <tt>[−2<sup>31</sup>,
 * 2<sup>31</sup> − 1]</tt>. For this problem, assume that your function <b>returns 2<sup>31</sup> − 1 when the division result overflows</b>.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: dividend = 1, divisor = 1
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>-2<sup>31</sup> <= dividend, divisor <= 2<sup>31</sup> - 1</tt></li>
 * <li><tt>divisor != 0</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 23.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(divide(10, 3));              // 3
        System.out.println(divide(7, -3));              // -2
        System.out.println(divide(1, 2));               // 0
        System.out.println(divide(-2147483648, -1));    // 2147483647
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == divisor)
            return 1;
        if (dividend == 0 || divisor == Integer.MIN_VALUE)
            return 0;

        int extra = 0;

        if (dividend == Integer.MIN_VALUE) {
            extra++;
            dividend += Math.abs(divisor);
        }

        boolean negative = Math.min(dividend, divisor) < 0 && 0 < Math.max(dividend, divisor);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int res = 0;

        while (dividend >= divisor) {
            int x = 1;
            int y = divisor;
            boolean found = false;

            while (dividend >= y) {
                if ((y << 1) < 0) {
                    found = true;
                    break;
                }

                y += y;

                if (dividend >= y)
                    x += x;
            }

            dividend -= found ? y : y >> 1;
            res += x;
        }

        return negative ? -res - extra : res + extra;
    }

}
