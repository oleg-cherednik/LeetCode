/**
 * Roman numerals are represented by seven different symbols: <tt>I</tt>, <tt>V</tt>, <tt>X</tt>, <tt>L</tt>, <tt>C</tt>, <tt>D</tt> and <tt>M</tt>.
 * <p>
 * <pre>
 * Symbol       Value
 *   I           1
 *   V           5
 *   X           10
 *   L           50
 *   C           100
 *   D           500
 *   M           1000
 * </pre>
 * For example, two is written as <tt>II</tt> in Roman numeral, just two one's added together. Twelve is written as, <tt>XII</tt>, which is simply
 * <tt>X + II</tt>. The number twenty seven is written as <tt>XXVII</tt>, which is <tt>XX + V + II</tt>.
 * <ul>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <tt>IIII</tt>. Instead, the number
 * four is written as <tt>IV</tt>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as <tt>IX</tt>. There are six instances where subtraction is used:
 * <li><tt>I</tt> can be placed before <tt>V</tt> (5) and <tt>X</tt> (10) to make 4 and 9.</li>
 * <li><tt>X</tt> can be placed before <tt>L</tt> (50) and <tt>C</tt> (100) to make 40 and 90.</li>
 * <li><tt>C</tt> can be placed before <tt>D</tt> (500) and <tt>M</tt> (1000) to make 400 and 900.</li>
 * </ul>
 * <tt>Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 3
 * Output: "III"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 4
 * Output: "IV"
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 9
 * Output: "IX"
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(intToRoman(3));      // III
        System.out.println(intToRoman(4));      // IV
        System.out.println(intToRoman(9));      // IX
        System.out.println(intToRoman(58));     // LVIII
        System.out.println(intToRoman(1994));   // MCMXCIV
        System.out.println(intToRoman(10));     // X
        System.out.println(intToRoman(11));     // XI
    }

    public static String intToRoman(int num) {
        StringBuilder buf = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) {
                buf.append(_1000_);
                num -= 1000;
            } else if (num >= 900) {
                buf.append(_100_);
                buf.append(_1000_);
                num -= 900;
            } else if (num >= 500) {
                buf.append(_500_);
                num -= 500;
            } else if (num >= 400) {
                buf.append(_100_);
                buf.append(_500_);
                num -= 400;
            } else if (num >= 100) {
                buf.append(_100_);
                num -= 100;
            } else if (num >= 90) {
                buf.append(_10_);
                buf.append(_100_);
                num %= 10;
            } else if (num >= 50) {
                buf.append(_50_);
                num -= 50;
            } else if (num >= 40) {
                buf.append(_10_);
                buf.append(_50_);
                num -= 40;
            } else if (num >= 10) {
                buf.append(_10_);
                num -= 10;
            } else if (num == 9) {
                buf.append(_1_);
                buf.append(_10_);
                num = 0;
            } else if (num >= 5) {
                buf.append(_5_);
                num -= 5;
            } else if (num == 4) {
                buf.append(_1_);
                buf.append(_5_);
                num -= 4;
            } else {
                buf.append(_1_);
                num -= 1;
            }
        }

        return buf.toString();
    }

    private static final char _1_ = 'I';
    private static final char _5_ = 'V';
    private static final char _10_ = 'X';
    private static final char _50_ = 'L';
    private static final char _100_ = 'C';
    private static final char _500_ = 'D';
    private static final char _1000_ = 'M';

}
