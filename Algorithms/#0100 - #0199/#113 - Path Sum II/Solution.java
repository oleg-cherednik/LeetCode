import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <p>
 * Given the below binary tree and <tt>sum = 22</tt>,
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * </pre>
 * Return:
 * <pre>
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(pathSumStr(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 }, 22)); // [[5,4,11,2],[5,8,4,5]]
        System.out.println(pathSumStr(new Integer[] { -2, null, -3 }, -5)); // [[-2,-3]]
    }

    private static String pathSumStr(Integer[] vals, int sum) {
        TreeNode root = build(vals);
        List<List<Integer>> res = pathSum(root, sum);
        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (List<Integer> row : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(row.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }

        return buf.append(']').toString();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        pathSum(root, sum, path, 0, res);

        return res;
    }

    private static void pathSum(TreeNode node, int sum, Deque<Integer> path, int curSum, List<List<Integer>> res) {
        if (node == null)
            return;

        curSum += node.val;
        path.addLast(node.val);

        if (curSum == sum && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));
        else {
            pathSum(node.left, sum, path, curSum, res);
            pathSum(node.right, sum, path, curSum, res);
        }

        path.removeLast();
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
