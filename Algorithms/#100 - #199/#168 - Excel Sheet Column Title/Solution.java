/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <pre>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * </pre>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1
 * Output: "A"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 28
 * Output: "AB"
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 701
 * Output: "ZY"
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(convertToTitle(1));      // A
        System.out.println(convertToTitle(28));     // AB
        System.out.println(convertToTitle(701));    // ZY
        System.out.println(convertToTitle(52));     // AZ
        System.out.println(convertToTitle(702));    // ZZ
    }

    public static String convertToTitle(int n) {
        StringBuilder buf = new StringBuilder();

        while (n > 0) {
            int digit = n == 26 ? 26 : (n % 26);
            int x = 0;

            if (digit == 0) {
                x = 1;
                buf.append('Z');
            } else
                buf.append((char)('A' + digit - 1));

            n = n == 26 ? 0 : (n / 26) - x;
        }

        return buf.reverse().toString();
    }

}
