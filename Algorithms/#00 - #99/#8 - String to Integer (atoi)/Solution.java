import java.math.BigDecimal;

/**
 * Implement <tt>atoi</tt> which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical
 * value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of
 * this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is
 * empty
 * or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>Only the space character <tt>' '</tt> is considered as whitespace character.</li>
 * <li>Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>,
 * 2<sup>31</sup> − 1]. If the numerical value is out of the range of representable values, INT_MAX (2<sup>31</sup> − 1) or INT_MIN (−2<sup>31</sup>)
 * is returned.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> "42"
 * <b>Output:</b> 42
 * </pre>
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> "   -42"
 * <b>Output:</b> -42
 * <b>Explanation:</b> The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * <b>Input:</b> "4193 with words"
 * <b>Output:</b> 4193
 * <b>Explanation:</b> Conversion stops at digit '3' as the next character is not a numerical digit.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * <b>Input:</b> "words and 987"
 * <b>Output:</b> 0
 * <b>Explanation:</b> The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * <b>Input:</b> "-91283472332"
 * <b>Output:</b> -2147483648
 * <b>Explanation:</b> The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−2<sup>31</sup>) is returned.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String str) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (buf.length() == 0) {
                if (ch == '-' || ch == '+' || (ch >= '0' && ch <= '9'))
                    buf.append(ch);
                else if (ch != ' ')
                    return 0;
            } else if (ch < '0' || ch > '9')
                break;
            else
                buf.append(ch);
        }

        try {
            BigDecimal res = new BigDecimal(buf.toString());

            if (res.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0)
                return Integer.MAX_VALUE;
            if (res.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0)
                return Integer.MIN_VALUE;

            return res.intValue();
        } catch(Exception e) {
            return 0;
        }
    }
}
