/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: <tt>k[encoded_string]</tt>, where the <tt>encoded_string</tt> inside the square brackets is being repeated exactly
 * <tt>k</tt>
 * times. Note that <tt>k</tt> is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, <tt>k</tt>. For
 * example, there won't be input like <tt>3a</tt> or <tt>2[4]</tt></tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 30</tt></li>
 * <li><tt>s</tt> consists of lowercase English letters, digits, and square brackets <tt>'[]'</tt>,</li>
 * <li><tt>s</tt> is guaranteed to be a valid input.</li>
 * <li>All the integers in <tt>s</tt> are in the range <tt>[1, 300]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(decodeString("3[a]2[bc]"));      // aaabcbc
        System.out.println(decodeString("3[a2[c]]"));       // accaccacc
        System.out.println(decodeString("2[abc]3[cd]ef"));  // abcabccdcdcdef
        System.out.println(decodeString("abc3[cd]xyz"));    // abccdcdcdxyz
    }

    public static String decodeString(String s) {
        return decodeString(s, new int[] { 0 });
    }

    private static String decodeString(String s, int[] i) {
        StringBuilder res = new StringBuilder();

        while (i[0] < s.length() && s.charAt(i[0]) != ']') {
            if (Character.isLetter(s.charAt(i[0])))
                res.append(s.charAt(i[0]++));
            else if (Character.isDigit(s.charAt(i[0]))) {
                int k = 0;

                while (Character.isDigit(s.charAt(i[0]))) {
                    k = k * 10 + (s.charAt(i[0]) - '0');
                    i[0]++;
                }

                i[0]++; // skip '['
                StringBuilder buf = new StringBuilder();

                while (s.charAt(i[0]) != ']') {
                    buf.append(Character.isDigit(s.charAt(i[0])) ? decodeString(s, i) : s.charAt(i[0]++));
                }

                i[0]++; // skip ']'

                for (int j = 0; j < k; j++)
                    res.append(buf);
            }
        }

        return res.toString();
    }

}
