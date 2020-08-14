import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 * <p>
 * The tree has no more than <tt>1000</tt> nodes and the values are in the range <tt>-1000000</tt> to <tt>1000000</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 08.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(pathSum(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 }, 8));    // 3
        System.out.println(pathSum(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5 }, 3));        // 2
        System.out.println(pathSum(new Integer[] { 1, 2 }, 2));        // 1
    }

    private static int pathSum(Integer[] vals, int sum) {
        TreeNode root = build(vals);
        return pathSum(root, sum);
    }

    public static int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new TreeNode(0));
    }

    private static int pathSum(TreeNode node, int sum, TreeNode res) {
        if (node == null)
            return 0;

        helper(node, sum, res);
        pathSum(node.left, sum, res);
        pathSum(node.right, sum, res);
        return res.val;
    }

    private static void helper(TreeNode node, int sum, TreeNode res) {
        if (node == null)
            return;

        if (node.val == sum)
            res.val++;

        helper(node.left, sum - node.val, res);
        helper(node.right, sum - node.val, res);
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

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

}
