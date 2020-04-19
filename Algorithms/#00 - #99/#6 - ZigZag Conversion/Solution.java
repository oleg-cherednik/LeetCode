/**
 * The string <tt>"PAYPALISHIRING"</tt> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a
 * fixed font for better legibility)
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * And then read line by line: <tt>"PAHNAPLSIIGYIR"</tt>
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <pre>
 * string convert(string s, int numRows);
 * </pre>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 19.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(convert("AB", 1));             // PINALSIGYAHRPI
        System.out.println(convert("ABCD", 3));           // ABDC
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int step = numRows * 2 - 2;
        StringBuilder buf = new StringBuilder(s.length());

        for (int i = 0; i < numRows; i++) {
            for (int j = 0, k = step - i; j + i < s.length(); j += step, k += step) {
                buf.append(s.charAt(j + i));

                if (k != j + i && k < j + step && k < s.length())
                    buf.append(s.charAt(k));
            }
        }

        return buf.toString();
    }

}
