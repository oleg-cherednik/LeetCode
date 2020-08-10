/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <pre>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * </pre>
 * <b>Example 1:</b>
 * <pre>
 * Input: "A"
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "AB"
 * Output: 28
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "ZY"
 * Output: 701
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(titleToNumber("A"));  // 1
        System.out.println(titleToNumber("AB"));  // 28
        System.out.println(titleToNumber("ZY"));  // 701
    }

    public static int titleToNumber(String s) {
        int res = 0;

        for (int i = s.length() - 1, mul = 1; i >= 0; i--, mul *= 26)
            res += (Character.toUpperCase(s.charAt(i)) - 'A' + 1) * mul;

        return res;
    }

}
