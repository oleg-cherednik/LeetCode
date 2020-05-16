import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer <tt>n</tt>, return a list of all <b>simplified</b> fractions between 0 and 1 (exclusive) such that the denominator is
 * less-than-or-equal-to <tt>n</tt>. The fractions can be in <b>any</b> order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 2
 * Output: ["1/2"]
 * Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 3
 * Output: ["1/2","1/3","2/3"]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 4
 * Output: ["1/2","1/3","1/4","2/3","3/4"]
 * Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 1
 * Output: []
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(simplifiedFractions(1)); // []
        System.out.println(simplifiedFractions(2)); // [1/2]
        System.out.println(simplifiedFractions(3)); // [1/2, 1/3, 2/3]
        System.out.println(simplifiedFractions(4)); // [1/2, 1/3, 1/4, 2/3, 3/4]
    }

    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            out:
            for (int j = i + 1; j <= n; j++) {
                for (int k = 2; k <= i; k++)
                    if (i % k == 0 && j % k == 0)
                        continue out;

                res.add(i + "/" + j);
            }
        }

        return res;
    }
}
