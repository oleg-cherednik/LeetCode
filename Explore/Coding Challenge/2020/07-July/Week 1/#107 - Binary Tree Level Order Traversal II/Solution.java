import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the <i>bottom-up level order</i> traversal of its nodes' values. (ie, from left to right, level by level from leaf to
 * root).
 * <p>
 * For example:<br>
 * Given binary tree <tt>[3,9,20,null,null,15,7]</tt>,
 * <pre>
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * </pre>
 * return its bottom-up level order traversal as:
 * <pre>
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(levelOrderBottom(3, 9, 20, null, null, 15, 7));  // [[15,7],[9,20],[3]]
        System.out.println(levelOrderBottom());                             // []
        System.out.println(levelOrderBottom(1, 2));                         // [[2],[1]]
    }

    private static String levelOrderBottom(Integer... vals) {
        TreeNode root = build(vals);
        List<List<Integer>> res = levelOrderBottom(root);

        StringBuilder buf = new StringBuilder().append('[');

        for (List<Integer> values : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(values.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }

        return buf.append(']').toString();
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        Deque<List<Integer>> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            stack.push(level);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if (node == null)
                    continue;

                level.add(node.val);

                if (node.left != null || node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(stack.size());

        while (!stack.isEmpty())
            res.add(stack.pop());

        return res;
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
