import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the <tt>root</tt> of a binary tree, return <i>all root-to-leaf paths in <b>any order</b></i>.
 * <p>
 * A <b>leaf</b> is a node with no children.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="paths-tree.jpg" />
 * <pre>
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: root = [1]
 * Output: ["1"]
 * </pre>
 * <ul>
 * <b>Constraint:</b>
 * <li><tt>The number of nodes in the tree is in the range <tt>[1, 100]</tt>.</tt></li>
 * <li><tt>-100 <= Node.val <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(binaryTreePaths(build(1, 2, 3, null, 5)));   // [1->2->5, 1->3]
        System.out.println(binaryTreePaths(build(1)));                  // [1]
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return dfs(root, new LinkedList<>(), new ArrayList<>());
    }

    private static List<String> dfs(TreeNode parent, Deque<Integer> queue, List<String> res) {
        if (parent == null)
            return res;

        queue.add(parent.val);

        if (parent.left == null && parent.right == null)
            res.add(createPath(queue));
        else {
            dfs(parent.left, queue, res);
            dfs(parent.right, queue, res);
        }

        queue.removeLast();

        return res;
    }

    private static String createPath(Deque<Integer> queue) {
        StringBuilder buf = new StringBuilder();

        for (int val : queue) {
            if (buf.length() > 0)
                buf.append("->");
            buf.append(val);
        }

        return buf.toString();
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
