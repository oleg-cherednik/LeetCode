import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree containing digits from <tt>0-9</tt> only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path <tt>1->2->3</tt> which represents the number <tt>123</tt>.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 27.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(sumNumbers(1, 2, 3));        // 25
        System.out.println(sumNumbers(4, 9, 0, 5, 1));  // 1026
    }

    private static int sumNumbers(Integer... vals) {
        TreeNode root = build(vals);
        return sumNumbers(root);
    }

    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }

    private static int sumNumbers(TreeNode node, int sum, int res) {
        if (node == null)
            return res;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null)
            return res + sum;

        res = sumNumbers(node.left, sum, res);
        res = sumNumbers(node.right, sum, res);

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

        TreeNode(int val) {
            this.val = val;
        }
    }

}
