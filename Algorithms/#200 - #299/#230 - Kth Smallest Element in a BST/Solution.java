import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary search tree, write a function <tt>kthSmallest</tt> to find the <b>k</b>th smallest element in it.
 * <p>
 * <b>Note:</b><br>
 * You may assume <tt>k</tt> is always valid, <tt>1 ≤ k ≤ BST's total elements</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * </pre>
 * <b>Follow up:</b><br>
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 *
 * @author Oleg Cherednik
 * @since 20.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kthSmallest(build(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15), 7));   // 7
        System.out.println(kthSmallest(build(3, 1, 4, null, 2), 1));                // 1
        System.out.println(kthSmallest(build(5, 3, 6, 2, 4, null, null, 1), 3));    // 3
    }

    public static int kthSmallest(TreeNode root, int k) {
        return dfs(root, new TreeNode(k)).val;
    }

    private static TreeNode dfs(TreeNode node, TreeNode k) {
        if (node == null || k.val == 0)
            return null;

        TreeNode res = dfs(node.left, k);

        if (k.val == 0)
            return res;
        if (--k.val == 0)
            return node;
        return dfs(node.right, k);
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
