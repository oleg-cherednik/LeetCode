import java.util.Arrays;

/**
 * <ul>
 * Given the array <tt>queries</tt> of positive integers between <tt>1</tt> and <tt>m</tt>, you have to process all <tt>queries[i]</tt> (from
 * <tt>i=0</tt> to <tt>i=queries.length-1</tt>) according to the following rules:
 * <li>In the beginning, you have the permutation <tt>P=[1,2,3,...,m]</tt>.</li>
 * <li>For the current <tt>i</tt>, find the position of <tt>queries[i]</tt> in the permutation <tt>P</tt> (<b>indexing from 0</b>) and then move this
 * at the beginning of the permutation <tt>P</tt>. Notice that the position of <tt>queries[i]</tt> in <tt>P</tt> is the result for <tt>queries[i]</tt>.</li>
 * </ul>
 * Return an array containing the result for the given <tt>queries</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: queries = [3,1,2,1], m = 5
 * Output: [2,1,2,1]
 * Explanation: The queries are processed as follow:
 * For i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2, then we move 3 to the beginning of P resulting in P=[3,1,2,4,5].
 * For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,3,2,4,5].
 * For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2, then we move 2 to the beginning of P resulting in P=[2,1,3,4,5].
 * For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,2,3,4,5].
 * Therefore, the array containing the result is [2,1,2,1].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: queries = [4,1,2,2], m = 4
 * Output: [3,1,2,0]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: queries = [7,5,5,8,3], m = 8
 * Output: [6,5,0,7,5]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= m <= 10<sup>3</sup></tt></li>
 * <li><tt>1 <= queries.length <= m</tt></li>
 * <li><tt>1 <= queries[i] <= m</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(processQueries(new int[] { 3, 1, 2, 1 }, 5)));
        System.out.println(Arrays.toString(processQueries(new int[] { 4, 1, 2, 2 }, 4)));
        System.out.println(Arrays.toString(processQueries(new int[] { 7, 5, 5, 8, 3 }, 8)));
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] arr = new int[m];
        int[] res = new int[queries.length];

        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;

        for (int i = 0, j = 0; i < queries.length; i++, j = 0) {
            while (j < arr.length && arr[j] != queries[i])
                j++;

            res[i] = j;

            if (j > 0) {
                System.arraycopy(arr, 0, arr, 1, j);
                arr[0] = queries[i];
            }
        }

        return res;
    }
}
