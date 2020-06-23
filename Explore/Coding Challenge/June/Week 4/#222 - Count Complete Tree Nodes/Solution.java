import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a <b>complete</b> binary tree, count the number of nodes.
 * <p>
 * <b>Note:</b>
 * <p>
 * <b><u>Definition of a complete binary tree from <a href="https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees">Wikipedia</a>:</u></b>
 * <p>
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2<sup>h</sup> nodes inclusive at the last level h.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 24.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countNodes(1, 2, 3, 4, 5, 6));    // 6
    }

    private static int countNodes(Integer... vals) {
        TreeNode root = build(vals);
        return countNodes(root);
    }

    public static int countNodes(TreeNode root) {
        return countNodes(root, new TreeNode());
    }

    private static int countNodes(TreeNode node, TreeNode res) {
        if (node != null) {
            res.val++;
            countNodes(node.left, res);
            countNodes(node.right, res);
        }

        return res.val;
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

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
