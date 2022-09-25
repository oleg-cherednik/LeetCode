import java.util.Arrays;

/**
 * Given an integer <tt>n</tt>, return <b>any</b> array containing <tt>n</tt> <b>unique</b> integers such that they
 * add up to <tt>0</tt>.<p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 3
 * Output: [-1,0,1]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 1
 * Output: [0]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 25.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(1)));
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;

        for (int i = 1; i < n; i++) {
            res[i] = i;
            sum += i;
        }

        res[0] = -sum;

        return res;
    }

}
