import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth <tt>0</tt>, and children of each depth <tt>k</tt> node are at depth <tt>k+1</tt>.
 * <p>
 * Two nodes of a binary tree are <i>cousins</i> if they have the same depth, but have <b>different parents</b>.
 * <p>
 * We are given the <tt>root</tt> of a binary tree with unique values, and the values <tt>x</tt> and <tt>y</tt> of two different nodes in the tree.
 * <p>
 * Return <tt>true</tt> if and only if the nodes corresponding to the values <tt>x</tt> and <tt>y</tt> are cousins.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="q1248-01.png" />
 * <pre>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="q1248-02.png" />
 * <pre>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="q1248-03.png" />
 * <pre>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The number of nodes in the tree will be between <tt>2</tt> and <tt>100</tt>.</li>
 * <li>Each node has a unique integer value from <tt>1</tt> to <tt>100</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isCousins(build(1, 2, 3, 4), 4, 3));                 // false
        System.out.println(isCousins(build(1, 2, 3, null, 4, null, 5), 5, 4));  // true
        System.out.println(isCousins(build(1, 2, 3, null, 4), 2, 3));           // false
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int[] parents = { -1, -1 };
        int[] depths = { -1, -2 };

        dfs(null, root, 0, x, y, parents, depths);

        return parents[0] != parents[1] && depths[0] == depths[1];
    }

    private static void dfs(TreeNode parent, TreeNode node, int depth, int x, int y, int[] parents, int[] depths) {
        if (node == null)
            return;

        if (node.val == x) {
            parents[0] = parent == null ? -1 : parent.val;
            depths[0] = depth;
        }

        if (node.val == y) {
            parents[1] = parent == null ? -2 : parent.val;
            depths[1] = depth;
        }

        dfs(node, node.left, depth + 1, x, y, parents, depths);
        dfs(node, node.right, depth + 1, x, y, parents, depths);
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
