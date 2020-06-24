/**
 * Given <tt>n</tt>, how many structurally unique <b>BST's</b> (binary search trees) that store values <tt>1 ... n</tt>?
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numTrees(3));    // 5
    }

    public static int numTrees(int n) {
        int[] total = new int[n + 1];
        total[0] = 1;
        total[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                total[i] += total[j] * total[i - j - 1];

        return total[n];
    }
}
