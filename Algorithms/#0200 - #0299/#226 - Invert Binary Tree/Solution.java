import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Invert a binary tree.
 * <p>
 * <b>Example:</b>
 * <p>
 * Input:
 * <pre>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * </pre>
 * Output:
 * <pre>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * </pre>
 * <b>Trivia:</b>
 * <p>
 * This problem was inspired by this <a href="https://twitter.com/mxcl/status/608682016205344768">original tweet</a> by <a
 * href="https://twitter.com/mxcl">Max Howell</a>:
 * <blockquote>
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * </blockquote>
 *
 * @author Oleg Cherednik
 * @since 01.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(invertTree(4, 2, 7, 1, 3, 6, 9));    // [[4][7,2][9,6,3,1]]
    }

    private static String invertTree(Integer... vals) {
        TreeNode root = build(vals);
        root = invertTree(root);

        StringBuilder buf = new StringBuilder().append('[');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int total = queue.size();

            List<Integer> values = new ArrayList<>();
            boolean add = false;

            for (int i = 0; i < total; i++) {
                TreeNode node = queue.remove();

                if (node == null)
                    values.add(null);
                else {
                    values.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                    add = true;
                }
            }

            if (add)
                buf.append(values.stream()
                                 .map(val -> val == null ? null : String.valueOf(val))
                                 .collect(Collectors.joining(",", "[", "]")));
        }

        return buf.append(']').toString();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode right = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = right;

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
