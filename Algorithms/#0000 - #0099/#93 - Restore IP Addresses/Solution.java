import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * A <b>valid IP address</b> consists of exactly four integers separated by single dots. Each integer is between
 * <tt>0</tt> and <tt>255</tt> (inclusive) and cannot have leading zeros.
 * <ul>
 * <li>For example, <tt>"0.1.2.201"</tt> and <tt>"192.168.1.1"</tt> are <b>valid</b> IP addresses, but
 * <tt>"0.011.255.245"</tt>, <tt>"192.168.1.312"</tt> and <tt>"192.168@1.1"</tt> are <b>invalid</b> IP addresses.</li>
 * </ul>
 * Given a string <tt>s</tt> containing only digits, return <i>all possible valid IP addresses that can be formed by
 * inserting dots into <tt>s</tt></i>. You are <b>not</b> allowed to reorder or remove any digits in <tt>s</tt>. You
 * may return the valid IP addresses in <b>any</b> order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * </pre>
 * <b>Constraint:</b>
 * <li><tt>1 <= s.length <= 20</tt></li>
 * <li><tt>s</tt> consists of digits only</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(restoreIpAddresses("25525511135"));   // [255.255.11.135, 255.255.111.35]
        System.out.println(restoreIpAddresses("0000"));          // [0.0.0.0]
        System.out.println(restoreIpAddresses("101023"));        // [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
        System.out.println(restoreIpAddresses("172162541"));     // [17.216.25.41, 17.216.254.1, 172.16.25.41, 172.16.254.1,
                                                                 //  172.162.5.41, 172.162.54.1]
    }

    public static List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(new LinkedList<>(), null, s, 0, new ArrayList<>());
    }

    public static List<String> restoreIpAddresses(Deque<Integer> queue, Integer curr, String s, int i, List<String> res) {
        if (i >= s.length()) {
            if (curr == null) {
                if (queue.size() == 4)
                    res.add(createAddress(queue));
            } else if (queue.size() == 3 && curr <= 255) {
                queue.add(curr);
                res.add(createAddress(queue));
                queue.removeLast();
            }
        } else if (queue.size() < 4) {
            int digit = s.charAt(i) - '0';

            if (curr == null)
                restoreIpAddresses(queue, digit, s, i + 1, res);
            else if (curr == 0) {
                queue.add(0);
                restoreIpAddresses(queue, digit, s, i + 1, res);
                queue.removeLast();
            } else if (curr > 100) {
                if (curr <= 255) {
                    queue.add(curr);
                    restoreIpAddresses(queue, digit, s, i + 1, res);
                    queue.removeLast();
                }
            } else {
                queue.add(curr);
                restoreIpAddresses(queue, digit, s, i + 1, res);
                queue.removeLast();

                restoreIpAddresses(queue, curr * 10 + digit, s, i + 1, res);
            }
        }

        return res;
    }

    private static String createAddress(Deque<Integer> queue) {
        StringBuilder buf = new StringBuilder();

        for (int num : queue) {
            if (buf.length() > 0)
                buf.append('.');
            buf.append(num);
        }

        return buf.toString();
    }
}
