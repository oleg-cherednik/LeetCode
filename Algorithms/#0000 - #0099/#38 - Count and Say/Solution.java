/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <pre>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * </pre>
 * <tt>1</tt> is read off as <tt>"one 1"</tt> or <tt>11</tt>.<br>
 * <tt>11</tt> is read off as <tt>"two 1s"</tt> or <tt>21</tt>.<br>
 * <tt>21</tt> is read off as <tt>"one 2</tt>, then <tt>one 1"</tt> or <tt>1211</tt>.
 * <p>
 * Given an integer <tt>n</tt> where <tt>1 ≤ n ≤ 30</tt>, generate the <tt>n<sup>th</sup></tt> term of the count-and-say sequence. You can do so
 * recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2,
 * the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countAndSay(1)); // 1
        System.out.println(countAndSay(4)); // 1211
    }

    public static String countAndSay(int n) {
        String res = "1";

        for (int i = 2; i <= n; i++) {
            int count = 1;
            char ch = res.charAt(0);
            StringBuilder buf = new StringBuilder();

            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == ch)
                    count++;
                else {
                    buf.append(count).append(ch);
                    ch = res.charAt(j);
                    count = 1;
                }
            }

            res = buf.append(count).append(ch).toString();
        }

        return res;
    }

}
