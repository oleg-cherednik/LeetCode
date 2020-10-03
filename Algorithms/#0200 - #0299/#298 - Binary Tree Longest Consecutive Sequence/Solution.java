import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, final the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes, from some starting node to any node in the tree along the parent-child connections. The longest
 * consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *        \
 *         5
 *
 * Output: 3
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLongest(1, null, 3, 2, 4, null, null, null, 5));   // 1
    }

    private static int findLongest(Integer... vals) {
        TreeNode root = build(vals);
        return findLongest(root);
    }

    public static int findLongest(TreeNode root) {
        return findLongest(-1, root, 0, new TreeNode(0)).val;
    }

    private static TreeNode findLongest(int prv, TreeNode node, int count, TreeNode res) {
        if (node == null)
            return res;

        count = prv != -1 && prv + 1 == node.val ? count + 1 : 1;
        res.val = Math.max(res.val, count);

        findLongest(node.val, node.left, count, res);
        findLongest(node.val, node.right, count, res);
        return res;
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
