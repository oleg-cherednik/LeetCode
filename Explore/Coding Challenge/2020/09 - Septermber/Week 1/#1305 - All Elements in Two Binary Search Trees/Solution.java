import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two binary search trees <tt>root1</tt> and <tt>root2</tt>.
 * <p>
 * Return a list containing <i>all the integers</i> from <i>both trees</i> sorted in <b>ascending</b> order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <img src="q2-e1" />
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * <img src="q2-e5-.png" />
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>Each tree has at most <tt>5000</tt> nodes.</li>
 * <li>Each node's value is between <tt>[-10<sup>5</sup>, 10<sup>5</sup>]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 05.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getAllElements(new Integer[] { 2, 1, 4 }, new Integer[] { 1, 0, 3 }));           // [0, 1, 1, 2, 3, 4]
        System.out.println(getAllElements(new Integer[] { 0, -10, 10 }, new Integer[] { 5, 1, 7, 0, 2 }));  // [-10, 0, 0, 1, 2, 5, 7, 10]
        System.out.println(getAllElements(new Integer[] {}, new Integer[] { 5, 1, 7, 0, 2 }));              // [0, 1, 2, 5, 7]
        System.out.println(getAllElements(new Integer[] { 0, -10, 10 }, new Integer[] {}));                 // [-10, 0, 10]
        System.out.println(getAllElements(new Integer[] { 1, null, 8 }, new Integer[] { 8, 1 }));           // [1, 1, 8, 8]
    }

    public static List<Integer> getAllElements(Integer[] one, Integer[] two) {
        TreeNode root1 = build(one);
        TreeNode root2 = build(two);
        return getAllElements(root1, root2);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res);
        dfs(root2, res);
        res.sort(Integer::compare);
        return res;
    }

    private static void dfs(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            dfs(node.left, res);
            dfs(node.right, res);
        }
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
