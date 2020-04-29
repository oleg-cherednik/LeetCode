import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a <b>non-empty</b> binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain <b>at least one node</b> and does not need to go through the root.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 29.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxPathSum(build(1, 2, 3)));                                                         // 6
        System.out.println(maxPathSum(build(-10, 9, 20, null, null, 15, 7)));                                   // 42
        System.out.println(maxPathSum(build(-3)));                                                              // -3
        System.out.println(maxPathSum(build(2, -1)));                                                           // 2
        System.out.println(maxPathSum(build(1, -2, 3)));                                                        // 4
        System.out.println(maxPathSum(build(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6)));    // 16
    }

    private static TreeNode build(Integer... vals) {
        TreeNode root = null;
        Queue<TreeNode> nodes = new LinkedList<>();

        for (int i = 0; i < vals.length; ) {
            if (i == 0)
                nodes.add(root = new TreeNode(vals[i++]));
            else {
                if (nodes.isEmpty())
                    break;

                Integer left = vals[i++];
                Integer right = i < vals.length ? vals[i++] : null;
                TreeNode node = nodes.remove();

                if (left != null)
                    nodes.add(node.left = new TreeNode(left));
                if (right != null)
                    nodes.add(node.right = new TreeNode(right));
            }
        }

        return root;
    }

    public static int maxPathSum(TreeNode root) {
        int[] res = { Integer.MIN_VALUE };
        maxPathSum(root, res, 0);
        return res[0];
    }

    private static int maxPathSum(TreeNode parent, int[] res, int sum) {
        if (parent == null)
            return sum;

        int leftSum = maxPathSum(parent.left, res, sum);
        int rightSum = maxPathSum(parent.right, res, sum);

        res[0] = Math.max(res[0], parent.val);
        res[0] = Math.max(res[0], parent.val + leftSum);
        res[0] = Math.max(res[0], parent.val + rightSum);
        res[0] = Math.max(res[0], leftSum + rightSum + parent.val);

        return Math.max(parent.val, Math.max(leftSum, rightSum) + parent.val);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
