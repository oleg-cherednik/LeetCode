import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * For a non-negative integer <tt>X</tt>, the <i>array-form</i> of <tt>X</tt> is an array of its digits in left to right order. For example, if <tt>X
 * = 1231</tt>, then the array form is <tt>[1,2,3,1]</tt>.
 * <p>
 * Given the array-form <tt>A</tt> of a non-negative integer <tt>X</tt>, return the array-form of the integer <tt>X+K</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * </pre>
 * <b>Note:</b>
 * <ol>
 * <li>1 <= A.length <= 10000</li>
 * <li>0 <= A[i] <= 9</li>
 * <li>0 <= K <= 10000</li>
 * <li>If A.length > 1, then A[0] != 0</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 23.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(addToArrayForm(new int[] { 1, 2, 0, 0 }, 34).stream().mapToInt(i -> i).toArray()));  // 1234
        System.out.println(Arrays.toString(addToArrayForm(new int[] { 2, 7, 4 }, 181).stream().mapToInt(i -> i).toArray()));    // 455
        System.out.println(Arrays.toString(addToArrayForm(new int[] { 2, 1, 5 }, 806).stream().mapToInt(i -> i).toArray()));    // 1021
        System.out.println(Arrays.toString(addToArrayForm(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, 1).stream().mapToInt(i -> i)
                                                                                                        .toArray()));    // 10000000000
        System.out.println(Arrays.toString(addToArrayForm(new int[] { 0 }, 23).stream().mapToInt(i -> i).toArray()));  // 23
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int offs = 0;

        for (int i = A.length - 1; i >= 0 && (K != 0 || offs != 0); i--) {
            A[i] += K % 10 + offs;
            offs = A[i] / 10;
            A[i] %= 10;
            K /= 10;
        }

        offs += K;

        List<Integer> res = new LinkedList<>();

        if (offs > 0) {
            String str = String.valueOf(offs);

            for (int i = 0; i < str.length(); i++)
                res.add(str.charAt(i) - '0');
        }

        for (int i = 0; i < A.length; i++)
            res.add(A[i]);

        return res;
    }
}
