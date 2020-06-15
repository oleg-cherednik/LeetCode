import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return <tt>NULL</tt>.
 * <p>
 * For example,
 * <pre>
 * Given the tree:
 *         4
 *       / \
 *      2   7
 *    / \
 *   1   3
 *
 * And the value to search: 2
 * </pre>
 * You should return this subtree:
 * <pre>
 *         2
 *       / \
 *      1   3
 * </pre>
 * In the example above, if we want to search the value <tt>5</tt>, since there is no node with value <tt>5</tt>, we should return <tt>NULL</tt>.
 * <p>
 * Note that an empty tree is represented by <tt>NULL</tt>, therefore you would see the expected output (serialized tree format) as <tt>[]</tt>, not
 * <tt>null</tt>.
 *
 * @author Oleg Cherednik
 * @since 15.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(searchBST(new Integer[] { 4, 2, null, 1, 3 }, 2));   // [2,1,3]
        System.out.println(searchBST(new Integer[] { 2, 1, 3 }, 5));            // null
    }

    public static String searchBST(Integer[] vals, int val) {
        TreeNode root = build(vals);
        root = searchBST(root, val);

        if (root == null)
            return null;

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            boolean hasMore = false;
            List<TreeNode> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove();

                if (buf.length() > 1)
                    buf.append(',');
                if (node == null)
                    buf.append((Integer)null);
                else {
                    buf.append(node.val);
                    row.add(node.left);
                    row.add(node.right);
                    hasMore = node.left != null || node.right != null;
                }
            }

            if (hasMore)
                nodes.addAll(row);
        }

        buf.append(']');
        return buf.toString();
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val == root.val)
            return root;
        if (val < root.val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
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
