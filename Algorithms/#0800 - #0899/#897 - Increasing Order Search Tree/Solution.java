import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the <tt>root</tt> of a binary search tree, rearrange the tree in <b>in-order</b> so that the leftmost node in the tree is now the root of the
 * tree, and every node has no left child and only one right child.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="ex1.jpg" />
 * <pre>
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="ex2.jpg" />
 * <pre>
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the given tree will be in the range <tt>[1, 100]</tt>.</li>
 * <li><tt>0 <= Node.val <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(increasingBST(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9));   // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(increasingBST(5, 1, 7));   // [1, 5, 7]
    }

    private static List<Integer> increasingBST(Integer... vals) {
        TreeNode root = build(vals);
        root = increasingBST(root);

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = 0, total = queue.size(); i < total; i++) {
                TreeNode node = queue.remove();
                res.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return res;
    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        dfs(root, res);
        return res.right;
    }

    private static TreeNode dfs(TreeNode node, TreeNode res) {
        if (node != null) {
            res = dfs(node.left, res);
            res = res.right = new TreeNode(node.val);
            res = dfs(node.right, res);
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

        TreeNode(int val) {
            this.val = val;
        }
    }
}
