/**
 * Given two non-negative integers <tt>num1</tt> and <tt>num2</tt> represented as strings, return the product of <tt>num1</tt> and <tt>num2</tt>, also
 * represented as a string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The length of both <tt>num1</tt> and <tt>num2</tt> is <tt>< 110</tt>.</li>
 * <li>Both <tt>num1</tt> and <tt>num2</tt> contain only digits <tt>0-9</tt>.</li>
 * <li>Both <tt>num1</tt> and <tt>num2</tt> do not contain any leading zero, except the number <tt>0</tt> itself.</li>
 * <li>You <b>must not use any built-in BigInteger library</b> or <b>convert the inputs to integer directly</b>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 19.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(multiply("2", "3"));     // 6
        System.out.println(multiply("123", "456")); // 56088
    }

    public static String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; --i) {
            for (int j = num2.length() - 1; j >= 0; --j) {
                int r = res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] += r / 10;
                res[i + j + 1] = r % 10;
            }
        }

        StringBuilder buf = new StringBuilder();

        for (int i : res)
            if (buf.length() != 0 || i != 0)
                buf.append(i);

        return buf.length() == 0 ? "0" : buf.toString();
    }

}
