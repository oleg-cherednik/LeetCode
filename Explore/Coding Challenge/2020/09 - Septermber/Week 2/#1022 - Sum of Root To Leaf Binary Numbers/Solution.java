import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, each node has value <tt>0</tt> or <tt>1</tt>. Each root-to-leaf path represents a binary number starting with the most
 * significant bit. For example, if the path is <tt>0 -> 1 -> 1 -> 0 -> 1</tt>, then this could represent <tt>01101</tt> in binary, which is
 * <tt>13</tt>.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <img src="sum-of-root-to-leaf-binary-numbers.png" />
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The number of nodes in the tree is between <tt>1</tt> and <tt>1000</tt>.</li>
 * <li><tt>node.val</tt> is <tt>0</tt> or <tt>1</tt>.</li>
 * <li>The answer will not exceed <tt>2<sup>31</sup> - 1</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 04.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(sumRootToLeaf(1, 0, 1, 0, 1, 0, 1)); // 22
    }

    private static int sumRootToLeaf(Integer... vals) {
        TreeNode root = build(vals);
        return sumRootToLeaf(root);
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, new LinkedList<>(), 0);
    }

    private static int dfs(TreeNode node, Deque<TreeNode> stack, int cur) {
        if (node == null)
            return 0;

        cur = cur << 1 | node.val;

        if (node.left == null && node.right == null)
            return cur;

        try {
            stack.push(node);
            return dfs(node.left, stack, cur) + dfs(node.right, stack, cur);
        } finally {
            stack.pop();
        }
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
