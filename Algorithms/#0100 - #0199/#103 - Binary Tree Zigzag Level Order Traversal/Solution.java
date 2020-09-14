import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the <i>zigzag level order</i> traversal of its nodes' values. (ie, from left to right, then right to left for the next
 * level and alternate between).
 * <p>
 * For example:
 * Given binary tree <tt>[3,9,20,null,null,15,7]</tt>,
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * return its zigzag level order traversal as:
 * <pre>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(zigzagLevelOrder(3, 9, 20, null, null, 15, 7));  // [[3],[20,9],[15,7]]
        System.out.println(zigzagLevelOrder());                             // []
        System.out.println(zigzagLevelOrder(3));                            // [[3]]
    }

    private static String zigzagLevelOrder(Integer... vals) {
        TreeNode root = build(vals);
        List<List<Integer>> res = zigzagLevelOrder(root);

        StringBuilder buf = new StringBuilder().append('[');

        for (List<Integer> values : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(values.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }

        return buf.append(']').toString();
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                values.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            if (level % 2 == 0) {
                for (int i = 0, j = values.size() - 1; i < j; i++, j--) {
                    Integer tmp = values.get(i);
                    values.set(i, values.get(j));
                    values.set(j, tmp);
                }
            }

            res.add(values);
            level++;
        }

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
