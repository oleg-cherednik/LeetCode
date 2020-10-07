import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given the <tt>root</tt> node of a binary search tree (BST) and a <tt>value</tt> to insert into the tree. Return <i>the root node of the
 * BST
 * after the insertion</i>. It is <b>guaranteed</b> that the new value does not exist in the original BST.
 * <p>
 * <b>Notice</b> that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return <b>any
 * of them</b>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="insertbst.jpg" />
 * <pre>
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="bst.jpg" />
 * <pre>
 * Input: root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree will be in the range <tt>[0, 104]</tt>.</li>
 * <li>-10<sup>8</sup> <= Node.val <= 10<sup>8</sup></li>
 * <li>All the values <tt>Node.val</tt> are <b>unique</b>.</li>
 * <li>-10<sup>8</sup> <= val <= 10<sup>8</sup></li>
 * <li>It's <b>guaranteed</b> that <tt>val</tt> does not exist in the original BST.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(insertIntoBST(
                new Integer[] { 4, 2, 7, 1, 3 }, 5));   // [4,2,7,1,3,5,null]
        System.out.println(insertIntoBST(
                new Integer[] { 40, 20, 60, 10, 30, 50, 70 }, 25));        // [40,20,60,10,30,50,70,null,null,25,null,null,null,null,null]
        System.out.println(insertIntoBST(
                new Integer[] { 4, 2, 7, 1, 3, null, null, null, null, null, null }, 5));   // [4,2,7,1,3,5,null]
    }

    public static String insertIntoBST(Integer[] vals, int val) {
        TreeNode root = build(vals);
        root = insertIntoBST(root, val);

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
                    hasMore |= node.left != null || node.right != null;
                }
            }

            if (hasMore)
                nodes.addAll(row);
        }

        buf.append(']');
        return buf.toString();
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode node = root;

        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else
                    node = node.left;
            } else if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else
                    node = node.right;
            }
        }

        return root;
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

        public String toString() {
            return String.valueOf(val);
        }

    }

}
