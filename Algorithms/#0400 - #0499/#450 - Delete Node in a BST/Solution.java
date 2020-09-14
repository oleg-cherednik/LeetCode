import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * <ol>
 * Basically, the deletion can be divided into two stages:
 * <li>Search for a node to remove.</li>
 * <li>If the node is found, delete the node.</li>
 * </ol>
 * <b>Note:</b> Time complexity should be O(height of tree).
 * <b>Example:</b>
 * <pre>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 31.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(deleteNode(new Integer[] { 5, 3, 6, 2, 4, null, 7 }, 3));    // [5, 4, 6, 2, null, null, 7]
    }

    private static List<Integer> deleteNode(Integer[] vals, int key) {
        TreeNode root = build(vals);
        root = deleteNode(root, key);

        if (root == null)
            return null;

        List<Integer> res = new ArrayList<>();

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
                res.addAll(row);
        }

        return res;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode node = root;

        while (node != null && node.val != key) {
            parent = node;
            node = node.val > key ? node.left : node.right;
        }

        if (node == null)
            return root;

        if (node.right != null) {
            node.val = pollMinimumValue(node.right, node, true);
        } else if (parent != null) {
            if (node.val < parent.val)
                parent.left = node.left;
            else
                parent.right = node.left;
        } else
            return node.left;

        return root;
    }

    private static int pollMinimumValue(TreeNode node, TreeNode parent, boolean leaf) {
        if (node.left != null)
            return pollMinimumValue(node.left, node, false);

        if (leaf)
            parent.right = node.right;
        else
            parent.left = node.right;

        return node.val;
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
