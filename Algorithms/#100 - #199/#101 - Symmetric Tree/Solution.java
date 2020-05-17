import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree <tt>[1,2,2,3,4,4,3]</tt> is symmetric:
 * <pre>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * </pre>
 * <p>
 * But the following <tt>[1,2,2,null,3,null,3]</tt> is not:
 * <pre>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    4    3
 * </pre>
 * <p>
 * <b>Follow up:</b> Solve it both recursively and iteratively.
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isSymmetric(1, 2, 2, 3, 4, 4, 3));                                       // true
        System.out.println(isSymmetric(1, 2, 2, null, 3, null, 3));                                 // false
        System.out.println(isSymmetric(2, 3, 3, 4, 5, 5, 4, null, null, 8, 9, null, null, 9, 8));   // false
    }

    private static boolean isSymmetric(Integer... vals) {
        return isSymmetric(build(vals));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        List<Integer> left = bfs(root.left, true);
        List<Integer> right = bfs(root.right, false);

        if (left.size() != right.size())
            return false;

        for (int i = 0; i < left.size(); i++) {
            Integer one = left.get(i);
            Integer two = right.get(i);

            if (one == null ^ two == null)
                return false;
            if (one != null && !one.equals(two))
                return false;
        }

        return true;
    }

    private static List<Integer> bfs(TreeNode root, boolean leftToRight) {
        if (root == null)
            return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if (node == null)
                    res.add(null);
                else {
                    res.add(node.val);

                    if (leftToRight) {
                        queue.add(node.left);
                        queue.add(node.right);
                    } else {
                        queue.add(node.right);
                        queue.add(node.left);
                    }
                }
            }
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

        public String toString() {
            return String.valueOf(val);
        }
    }
}
