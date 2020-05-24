import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be <b>pseudo-palindromic</b> if at least one
 * permutation of the node values in the path is a palindrome.
 * <p>
 * <i>Return the number of <b>pseudo-palindromic</b> paths going from the root node to leaf nodes.</i>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="palindromic_paths_1.png" />
 * <pre>
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3],
 * the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path
 * [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="palindromic_paths_2.png" />
 * <pre>
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1]
 * Output: 1
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path
 * [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in
 * [1,2,1] (palindrome).
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root = [9]
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The given binary tree will have between <tt>1</tt> and <tt>10<sup>5</sup></tt> nodes.</li>
 * <li>Node values are digits from <tt>1</tt> to <tt>9</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(pseudoPalindromicPaths(2, 3, 1, 3, 1, 1));                               // 2
        System.out.println(pseudoPalindromicPaths(2, 1, 1, 1, 3, null, null, null, null, null, 1)); // 1
        System.out.println(pseudoPalindromicPaths(9));                                              // 1
    }

    private static int pseudoPalindromicPaths(Integer... vals) {
        TreeNode root = build(vals);
        return pseudoPalindromicPaths(root);
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        TreeNode res = new TreeNode(0);
        dfs(root, new int[10], res);
        return res.val;
    }

    private static void dfs(TreeNode node, int[] path, TreeNode res) {
        if (node == null)
            return;

        path[node.val]++;

        if (node.left == null && node.right == null && isPathPalindrome(path))
            res.val++;

        dfs(node.left, path, res);
        dfs(node.right, path, res);
        path[node.val]--;
    }

    private static boolean isPathPalindrome(int[] digits) {
        int one = 0;

        for (int digit : digits)
            if (digit % 2 != 0)
                one++;

        return one <= 1;
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
