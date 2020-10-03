import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <ul>
 * Assume a BST is defined as follows:
 * <li>The left subtree of a node contains only nodes with keys <b>less than</b> the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys <b>greater than</b> the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isValidBST(2, 1, 3));                    // true
        System.out.println(isValidBST(5, 1, 4, null, null, 3, 6));  // false
        System.out.println(isValidBST(-2147483648, -2147483648));   // false
    }

    private static boolean isValidBST(Integer... vals) {
        TreeNode root = build(vals);
        return isValidBST(root);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
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

        TreeNode(int val) {
            this.val = val;
        }
    }
}
