import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given the root of a binary <b>search</b> tree with distinct values, modify it so that every <tt>node</tt> has a new value equal to the sum of the
 * values of the original tree that are greater than or equal to <tt>node.val</tt>.
 * <ul>
 * As a reminder, a <i>binary search tree</i> is a tree that satisfies these constraints:
 * <li>The left subtree of a node contains only nodes with keys <b>less than</b> the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys <b>greater than</b> the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="tree.png" />
 * <pre>
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * </pre>
 * <ol>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is between <tt>1</tt> and <tt>100</tt>.</li>
 * <li>Each node will have value between <tt>0</tt> and <tt>100</tt>.</li>
 * <li>The given tree is a binary search tree.</li>
 * </ol>
 * <p>
 * <b>Note:</b> This question is the same as <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/">538. Convert BST to Greater Tree</a>
 *
 * @author Oleg Cherednik
 * @since 08.05.2020
 */
public class Solution {

    public static void main(String... args) {
        bstToGst(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);    // [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    }

    private static void bstToGst(Integer... values) {
        TreeNode root = build(values);
        root = bstToGst(root);
        System.out.println(toString(root));
    }

    public static TreeNode bstToGst(TreeNode root) {
        return dfs(root, new TreeNode(0));
    }

    private static TreeNode dfs(TreeNode node, TreeNode sum) {
        if (node == null)
            return node;

        dfs(node.right, sum);
        sum.val = node.val += sum.val;
        dfs(node.left, sum);
        return node;
    }

    private static String toString(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<TreeNode> tmp = new LinkedList<>();
            boolean empty = true;

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.remove();

                if (node == null)
                    values.add(null);
                else {
                    values.add(node.val);
                    empty &= node.left == null && node.right == null;
                    tmp.add(node.left);
                    tmp.add(node.right);
                }
            }

            if (!empty)
                nodes.addAll(tmp);
        }

        return values.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
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
