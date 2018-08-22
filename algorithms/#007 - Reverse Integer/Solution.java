/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> 123
 * <b>Output:</b> 321
 * </pre>
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> -123
 * <b>Output:</b> -321
 * </pre>
 * <p>
 * <b>Example 3:</b>
 * <pre>
 * <b>Input:</b> 120
 * <b>Output:</b> 21
 * </pre>
 * <p>
 * <b>Note:</b><br>
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>, 2<sup>31</sup>
 * − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author Oleg Cherednik
 * @since 17.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        boolean negative = x < 0;
        String str = String.valueOf(x);
        long res = Long.parseLong(new StringBuilder().append(negative ? str.substring(1) : str).append(negative ? "-" : "").reverse().toString());
        return (int)res != res ? 0 : (int)res;
    }

}
