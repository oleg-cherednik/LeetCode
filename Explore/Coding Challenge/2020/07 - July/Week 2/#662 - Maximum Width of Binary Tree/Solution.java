import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The
 * binary tree has the same structure as a <b>full binary tree</b>, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the
 * <tt>null</tt> nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 *
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * </pre>
 * <p>
 * <b>Note:</b> Answer will in the range of 32-bit signed integer.
 *
 * @author Oleg Cherednik
 * @since 09.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5, 3, null, 9)));   // 4
        System.out.println(widthOfBinaryTree(build(1, 2, null, 5, 3)));         // 2
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5)));               // 2
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5, null, null, 9, 6, null, null, 7)));  // 8
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = 0;
            int max = 0;

            for (int i = 0; i < size; i++) {
                root = queue.remove();
                if (i == 0)
                    min = root.val;
                if (i == size - 1)
                    max = root.val;

                if (root.left != null) {
                    root.left.val = root.val * 2 + 1;
                    queue.add(root.left);
                }

                if (root.right != null) {
                    root.right.val = root.val * 2 + 2;
                    queue.add(root.right);
                }
            }

            res = Math.max(res, max - min + 1);
        }

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

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
