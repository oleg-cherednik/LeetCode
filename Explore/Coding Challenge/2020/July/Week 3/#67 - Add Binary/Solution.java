/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both <b>non-empty</b> and contains only characters <tt>1</tt> or <tt>0</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: a = "11", b = "1"
 * Output: "100"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>Each string consists only of <tt>'0'</tt> or <tt>'1'</tt> characters.</li>
 * <li><tt>1 <= a.length</tt>, <tt>b.length <= 10<sup>4</sup></tt></li>
 * <li>Each string is either <tt>"0"</tt> or doesn't contain any leading zero</li>
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(addBinary("11", "1"));       // 100
        System.out.println(addBinary("1010", "1011"));  // 10101
        System.out.println(addBinary("111", "111"));    // 1110
    }

    public static String addBinary(String a, String b) {
        StringBuilder buf = new StringBuilder(Math.max(a.length(), b.length()) + 5);
        int count = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aa = i >= 0 ? a.charAt(i) - '0' : 0;
            int bb = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = aa + bb + count;

            buf.append(sum & 0x1);
            count = sum >> 1;
        }

        while (count > 0) {
            buf.append(count & 0x1);
            count >>= 1;
        }

        return buf.reverse().toString();
    }
}
