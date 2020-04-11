/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the <b>longest</b>
 * path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given a binary tree
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * </pre>
 * <b>Note:</b> The length of path between two nodes is represented by the number of edges between them.
 *
 * @author Oleg Cherednik
 * @since 09.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(diameterOfBinaryTree(build()));  // 3
    }

    private static TreeNode build() {
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(4);
        two.right = new TreeNode(5);

        TreeNode one = new TreeNode(1);
        one.left = two;
        one.right = new TreeNode(3);

        return one;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] max = { 0 };
        diameterOfBinaryTree(root, max);
        return max[0];
    }

    private static int diameterOfBinaryTree(TreeNode node, int[] max) {
        if (node == null)
            return 0;

        int left = node.left == null ? 0 : diameterOfBinaryTree(node.left, max) + 1;
        int right = node.right == null ? 0 : diameterOfBinaryTree(node.right, max) + 1;
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right);
    }

    public static final class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
