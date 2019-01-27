import java.util.function.LongToIntFunction;

/**
 * Roman numerals are represented by seven different symbols: <tt>I</tt>, <tt>V</tt>, <tt>X</tt>, <tt>L</tt>, <tt>C</tt>, <tt>D</tt> and <tt>M</tt>.
 * <pre>
 * <b>Symbol</b>    <b>Value</b>
 *   I        1
 *   V        5
 *   X        10
 *   L        50
 *   C        100
 *   D        500
 *   M        1000
 * </pre>
 * For example, two is written as <tt>II</tt> in Roman numeral, just two one's added together. Twelve is written as, <tt>XII</tt>, which is simply
 * <tt>X + II</tt>. The number twenty seven is written as <tt>XXVII</tt>, which is <tt>XX + V + II</tt>.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <tt>IIII</tt>. Instead, the number
 * four is written as <tt>IV</tt>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as <tt>IX</tt>. There are six instances where subtraction is used:
 * <ul>
 * <li><tt>I</tt> can be placed before <tt>V</tt> (5) and <tt>X</tt> (10) to make 4 and 9.</li>
 * <li><tt>X</tt> can be placed before <tt>L</tt> (50) and <tt>C</tt> (100) to make 40 and 90.</li>
 * <li><tt>C</tt> can be placed before <tt>D</tt> (500) and <tt>M</tt> (1000) to make 400 and 900.</li>
 * </ul>
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> "III"
 * <b>Output:</b> 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> "IV"
 * <b>Output:</b> 4
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * <b>Input:</b> "IX"
 * <b>Output:</b> 9
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * <b>Input:</b> "LVIII"
 * <b>Output:</b> 58
 * <b>Explanation:</b> L = 50, V= 5, III = 3
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * <b>Input:</b> "MCMXCIV"
 * <b>Output:</b> 1994
 * <b>Explanation:</b> M = 1000, CM = 900, XC = 90 and IV = 4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 27.01.2019
 */
public class Solution {

    public static int romanToInt(String s) {
        int res = 0;
        char prv = '\0';

        final LongToIntFunction convert = ch -> {
            if (ch == 'I')
                return 1;
            if (ch == 'V')
                return 5;
            if (ch == 'X')
                return 10;
            if (ch == 'L')
                return 50;
            if (ch == 'C')
                return 100;
            if (ch == 'D')
                return 500;
            if (ch == 'M')
                return 1000;
            return 0;
        };

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((ch == 'V' || ch == 'X') && prv == 'I') {
                res += convert.applyAsInt(ch) - convert.applyAsInt('I');
                prv = '\0';
            } else if ((ch == 'L' || ch == 'C') && prv == 'X') {
                res += convert.applyAsInt(ch) - convert.applyAsInt('X');
                prv = '\0';
            } else if ((ch == 'D' || ch == 'M') && prv == 'C') {
                res += convert.applyAsInt(ch) - convert.applyAsInt('C');
                prv = '\0';
            } else {
                res += convert.applyAsInt(prv);
                prv = ch;
            }
        }

        return res + convert.applyAsInt(prv);
    }

    public static void main(String... args) {
        System.out.println(romanToInt("III"));  // 3
        System.out.println(romanToInt("IV"));  // 4
        System.out.println(romanToInt("IX"));  // 9
        System.out.println(romanToInt("LVIII"));  // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }


}
