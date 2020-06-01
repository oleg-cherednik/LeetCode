import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree where each path going from the root to any leaf form a <b>valid sequence</b>, check if a given string is a <b>valid
 * sequence</b> in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers <tt>arr</tt> and the concatenation of all values of the nodes along a path
 * results in a <b>sequence</b> in the given binary tree.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="leetcode_testcase_11.png" />
 * <pre>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="leetcode_testcase_2.png" />
 * <pre>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="leetcode_testcase_3.png" />
 * <pre>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 5000</tt></li>
 * <li><tt>0 <= arr[i] <= 9</tt></li>
 * <li>Each node's value is between [0 - 9].</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 30.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isValidSequence(build(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] { 0, 1, 0, 1 }));    // true
        System.out.println(isValidSequence(build(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] { 0, 0, 1 }));       // false
        System.out.println(isValidSequence(build(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] { 0, 1, 1 }));       // false
        System.out.println(isValidSequence(build(8, 3, null, 2, 1, 5, 4), new int[] { 8 }));                            // false
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

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    private static boolean isValidSequence(TreeNode parent, int[] arr, int i) {
        if (parent == null)
            return i == arr.length;
        if (parent.val != arr[i])
            return false;
        if (i == arr.length - 1)
            return parent.left == null && parent.right == null;
        return isValidSequence(parent.left, arr, i + 1) || isValidSequence(parent.right, arr, i + 1);
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
