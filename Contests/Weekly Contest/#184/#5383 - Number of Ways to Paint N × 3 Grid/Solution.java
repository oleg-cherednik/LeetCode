/**
 * You have a <tt>grid</tt> of size <tt>n x 3</tt> and you want to paint each cell of the grid with exactly one of the three colours: <b>Red</b>,
 * <b>Yellow</b> or <b>Green</b> while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or
 * horizontal
 * sides have the same colour).
 * <p>
 * You are given <tt>n</tt> the number of rows of the grid.
 * <p>
 * Return <i>the number of ways</i> you can paint this <tt>grid</tt>. As the answer may grow large, the answer <b>must be</b> computed modulo
 * <tt>10<sup>9</sup> + 7</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 1
 * Output: 12
 * Explanation: There are 12 possible way to paint the grid as shown:
 * <img src="e1.png" />
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 2
 * Output: 54
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 3
 * Output: 246
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 7
 * Output: 106494
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: n = 5000
 * Output: 30228214
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>>n == grid.length</tt</li>
 * <li><tt>grid[i].length == 3</tt></li>
 * <li><tt>1 <= n <= 5000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numOfWays(1));       // 12
        System.out.println(numOfWays(2));       // 54
        System.out.println(numOfWays(3));       // 246
        System.out.println(numOfWays(7));       // 10649
        System.out.println(numOfWays(5000));    // 30228214
    }

    public static int numOfWays(int n) {
        long[] arr = new long[27];
        final int mod = 1000000007;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    if (i != j && j != k)
                        arr[i * 9 + j * 3 + k]++;

        for (int z = 1; z < n; z++) {
            long[] ndp = new long[27];

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 3; k++)
                        for (int m = 0; m < 3; m++)
                            for (int d = 0; d < 3; d++)
                                for (int p = 0; p < 3; p++)
                                    if (m != d && d != p && i != m && j != d && k != p)
                                        ndp[m * 9 + d * 3 + p] += arr[i * 9 + j * 3 + k];

            for (int i = 0; i < 27; i++)
                ndp[i] %= mod;

            arr = ndp;
        }

        long res = 0;

        for (long v : arr)
            res += v;

        return (int)(res % mod);
    }

}
