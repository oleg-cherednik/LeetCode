import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary string <tt>s</tt> and an integer <tt>k</tt>.
 * <p>
 * Return <tt>True</tt> if any binary code of length <tt>k</tt> is a substring of <tt>s</tt>. Otherwise, return <tt>False</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indicies 0, 1, 3 and 2
 * respectively.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "00110", k = 2
 * Output: true
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and doesn't exist in the array.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: s = "0000000001011100", k = 4
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 5 * 10<sup>5</sup></tt></li>
 * <li><tt>s</tt> consists of 0's and 1's only.
 * <li><tt>1 <= k <= 20</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 30.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hasAllCodes("00110110", 2));         // true
        System.out.println(hasAllCodes("00110", 2));            // true
        System.out.println(hasAllCodes("0110", 1));             // true
        System.out.println(hasAllCodes("0110", 2));             // false
        System.out.println(hasAllCodes("0000000001011100", 4)); // false
        System.out.println(hasAllCodes("00110", 2));            // true
    }

    public static boolean hasAllCodes(String s, int k) {
        Set<Integer> values = new HashSet<>();

        for (int i = 0, j = i + k; j <= s.length(); i++, j++)
            values.add(Integer.parseInt(s.substring(i, j), 2));

        return values.size() >= (int)Math.pow(2, k);
    }

}
