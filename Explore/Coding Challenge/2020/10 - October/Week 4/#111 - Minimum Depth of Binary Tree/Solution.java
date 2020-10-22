import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <p>
 * Given binary tree <tt>[3,9,20,null,null,15,7]</tt>,
 * <pre>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * </pre>
 * return its minimum depth = 2.
 *
 * @author Oleg Cherednik
 * @since 14.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minDepth());                             // 0
        System.out.println(minDepth(3, 9, 20, null, null, 15, 7));  // 2
    }

    private static int minDepth(Integer... vals) {
        TreeNode root = build(vals);
        return minDepth(root);
    }

    public static int minDepth(TreeNode root) {
        return root == null ? 0 : minDepth(root, 1, Integer.MAX_VALUE);
    }

    private static int minDepth(TreeNode node, int depth, int minDepth) {
        if (node == null)
            return minDepth;
        if (depth >= minDepth)
            return minDepth;
        if (node.left == null && node.right == null)
            return depth;
        return Math.min(minDepth(node.left, depth + 1, minDepth), minDepth(node.right, depth + 1, minDepth));
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
