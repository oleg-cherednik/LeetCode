import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given <tt>inorder</tt> and <tt>postorder</tt> traversal of a tree, construct the binary tree.
 * <p>
 * <b>Note:</b>
 * <p>
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <pre>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * </pre>
 * Return the following binary tree:
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 27.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(buildTreeList(new int[] { 9, 3, 15, 20, 7 },
                new int[] { 9, 15, 7, 20, 3 }));  // [3, 9, 20, null, null, 15, 7]
    }

    private static List<Integer> buildTreeList(int[] inorder, int[] postorder) {
        TreeNode root = buildTree(inorder, postorder);
        List<Integer> vals = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int total = queue.size();
            List<Integer> row = new ArrayList<>();
            boolean empty = true;

            for (int i = 0; i < total; i++) {
                TreeNode node = queue.remove();

                if (node == null)
                    row.add(null);
                else {
                    empty = false;
                    row.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!empty)
                vals.addAll(row);
        }

        return vals;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (postEnd < 0 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int i = inStart;
        for (; i < inEnd; i++)
            if (inorder[i] == root.val)
                break;

        root.left = buildTree(inorder, postorder, inStart, i - 1, postEnd - 1 + i - inEnd);
        root.right = buildTree(inorder, postorder, i + 1, inEnd, postEnd - 1);
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
