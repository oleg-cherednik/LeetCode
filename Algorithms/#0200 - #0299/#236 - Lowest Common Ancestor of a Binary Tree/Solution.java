import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor">definition of LCA on Wikipedia:</a> “The lowest common ancestor is
 * defined between two nodes <tt>p</tt> and <tt>q</tt> as the lowest node in <tt>T</tt> that has both p and q as descendants (where we allow <b>a node
 * to be a descendant of itself</b>).”
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="binarytree.png" />
 * <pre>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="binarytree.png" />
 * <pre>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is in the range <tt>[2, 10<sup>5</sup>]</tt>.</li>
 * <li><tt>-10<sup>9</sup> <= Node.val <= 10<sup>9</sup></tt></li>
 * <li>All <tt>Node.val</tt> are <b>unique</b>.</li>
 * <li><tt>p != q</tt></li>
 * <li><tt>p</tt> and <tt>q</tt> will exist in the tree.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(lowestCommonAncestor(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }, 5, 1));    // 3
        System.out.println(lowestCommonAncestor(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }, 5, 4));    // 5
        System.out.println(lowestCommonAncestor(new Integer[] { 1, 2 }, 1, 2));                                     // 1
        System.out.println(lowestCommonAncestor(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }, 5, 4));    // 5
    }

    private static int lowestCommonAncestor(Integer[] vals, int pVal, int qVal) {
        TreeNode root = build(vals);
        TreeNode p = find(root, pVal);
        TreeNode q = find(root, qVal);
        return lowestCommonAncestor(root, p, q).val;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    private static TreeNode find(TreeNode node, int val) {
        if (node == null)
            return null;
        if (node.val == val)
            return node;

        TreeNode res = find(node.left, val);
        return res == null ? find(node.right, val) : res;
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
