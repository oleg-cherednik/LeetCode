import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Return the root node of a binary <b>search</b> tree that matches the given <tt>preorder</tt> traversal.
 * <p>
 * <i>(Recall that a binary search tree is a binary tree where for every node, any descendant of <tt>node.left</tt> has a value <tt>< node.val</tt>,
 * and any descendant of <tt>node.right</tt> has a <tt>value > node.val</tt>.  Also recall that a preorder traversal displays the value of the
 * <tt>node</tt> first, then traverses <tt>node.left</tt>, then traverses <tt>node.right</tt>.)</i>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * </pre>
 * <img src="1266.png" />
 * <p>
 * <ul>
 * <b>Note:</b>
 * <li><tt>1 <= preorder.length <= 100</tt></li>
 * <li>The values of <tt>preorder</tt> are distinct.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 20.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(bstFromPreorderAndPrint(8, 5, 1, 7, 10, 12));    // [8,5,10,1,7,null,12]
    }

    private static String bstFromPreorderAndPrint(int... preorder) {
        TreeNode root = bstFromPreorder(preorder);
        List<Integer> vals = new ArrayList<>(preorder.length);

        Queue<TreeNode> row = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            row.clear();
            boolean empty = true;

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.remove();
                vals.add(node == null ? null : node.val);

                if (node == null) {
                    row.add(null);
                    row.add(null);
                } else {
                    empty &= node.left == null;
                    empty &= node.right == null;
                    row.add(node.left);
                    row.add(node.right);
                }
            }

            if (!empty)
                nodes.addAll(row);
        }

        return vals.stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]"));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++)
            add(root, preorder[i]);

        return root;
    }

    private static void add(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null)
                node.left = new TreeNode(val);
            else
                add(node.left, val);
        } else if (val > node.val) {
            if (node.right == null)
                node.right = new TreeNode(val);
            else
                add(node.right, val);
        }
    }

    public static class TreeNode {

        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
