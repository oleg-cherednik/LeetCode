import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <p>
 * Given binary tree <tt>[3,9,20,null,null,15,7]</tt>,
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * return its depth = 3.
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxDepth(3, 9, 20, null, null, 15, 7));  // 3
        System.out.println(maxDepth());                             // 0
    }

    private static int maxDepth(Integer... vals) {
        return maxDepth(build(vals));
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private static int dfs(TreeNode node, int depth) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return depth;
        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
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
