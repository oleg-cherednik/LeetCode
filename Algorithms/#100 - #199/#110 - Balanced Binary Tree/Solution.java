import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <blockquote>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * </blockquote>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *        3
 *       / \
 *      9  20
 *    /  \
 *  15   7
 *
 * Return true.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 *
 * Return false.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isBalanced(3, 9, 20, null, null, 15, 7));        // true
        System.out.println(isBalanced(1, 2, 2, 3, 3, null, null, 4, 4));    // false
    }

    private static boolean isBalanced(Integer... vals) {
        TreeNode root = build(vals);
        return isBalanced(root);
    }

    public static boolean isBalanced(TreeNode root) {
        return dfs(root, 0).balanced;
    }

    private static Data dfs(TreeNode node, int height) {
        if (node == null)
            return new Data(true, height);

        Data left = dfs(node.left, height + 1);
        Data right = dfs(node.right, height + 1);
        boolean balanced = left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1;
        return new Data(balanced, Math.max(left.height, right.height));
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

    public static class Data {
        boolean balanced;
        int height;

        public Data(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        int level = -1;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return String.format("%d (%d)", val, level);
        }
    }
}
