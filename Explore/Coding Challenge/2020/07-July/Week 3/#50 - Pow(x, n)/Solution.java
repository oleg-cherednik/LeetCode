import java.util.Locale;

/**
 * Implement <a href="http://www.cplusplus.com/reference/valarray/pow/">pow(x, n)</a>, which calculates <tt>x</tt> raised to the power <tt>n</tt>
 * <tt>(x<sup>n</sup>)</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 2.10000, 3
 * Output: 9.26100
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>-100.0 < x < 100.0</tt></li>
 * <li><tt>n</tt> is a 32-bit signed integer, within the range <tt>[−2<sup>31</sup>, 2<sup>31</sup> − 1]</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 17.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.format(Locale.ENGLISH, "%.3f\n", myPow(2, 10));  // 1024.000
        System.out.format(Locale.ENGLISH, "%.3f\n", myPow(2.1, 3)); // 9.261
        System.out.format(Locale.ENGLISH, "%.3f\n", myPow(2, -2));  // 0.250
    }

    public static double myPow(double x, int n) {
        double res = 1;
        long power = Math.abs((long)n);

        while (power > 0) {
            if ((power & 1) == 1)
                res *= x;

            x *= x;
            power >>= 1;
        }

        return n >= 0 ? res : 1 / res;
    }

}
