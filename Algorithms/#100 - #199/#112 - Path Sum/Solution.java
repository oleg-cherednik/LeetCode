import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given
 * sum.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <p>
 * Given the below binary tree and <tt>sum = 22</tt>,
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * </pre>
 * return <tt>true</tt>, as there exist a root-to-leaf path <tt>5->4->11->2</tt> which sum is <tt>22</tt>.
 *
 * @author Oleg Cherednik
 * @since 06.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hasPathSum(build(5, 4, 8, 11, null, 13, 5, 7, 2, null, null, null, 1), 22)); // true
        System.out.println(hasPathSum(build(1, -2, -3, 1, 3, -2, null, -1), -1));                       // true
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private static boolean hasPathSum(TreeNode node, int sum, int curSum) {
        if (node == null)
            return false;

        curSum += node.val;

        if (curSum == sum && node.left == null && node.right == null)
            return true;

        return hasPathSum(node.left, sum, curSum) || hasPathSum(node.right, sum, curSum);
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
    }
}
