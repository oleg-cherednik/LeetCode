/**
 * We write the integers of <tt>A</tt> and <tt>B</tt> (in the order they are given) on two separate horizontal lines.
 * <ul>
 * Now, we may draw <i>connecting lines</i>: a straight line connecting two numbers <tt>A[i]</tt> and <tt>B[j]</tt> such that:
 * <li><tt>A[i] == B[j]</tt>;</li>
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * </ul>
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="untitled-diagram-2.jpg" />
 * <pre>
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= A.length <= 500</tt></li>
 * <li><tt>1 <= B.length <= 500</tt></li>
 * <li><tt>1 <= A[i], B[i] <= 2000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 25.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxUncrossedLines(new int[] { 1, 4, 5 }, new int[] { 1, 2, 4 }));                    // 2
        System.out.println(maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));    // 3
        System.out.println(maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));     // 2
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; i--)
            for (int j = B.length - 1; j >= 0; j--)
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);

        return dp[0][0];
    }

}
