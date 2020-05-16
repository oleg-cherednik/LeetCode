import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a binary tree <tt>root</tt>, a node <tt>X</tt> in the tree is named <b>good</b> if in the path from root to <tt>X</tt> there are no nodes
 * with a value <i>greater than X</i>.
 * <p>
 * Return the number of <b>good</b> nodes in the binary tree.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="test_sample_1.png" />
 * <pre>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="test_sample_2.png" />
 * <pre>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the binary tree is in the range <tt>[1, 10<sup>5</sup>]</tt>.</li>
 * <li>Each node's value is between <tt>[-10<sup>4</sup>, 10<sup>4</sup>]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(goodNodes(build(3, 1, 4, 3, null, 1, 5)));   // 4
        System.out.println(goodNodes(build(3, 3, null, 4, 2)));         // 3
    }

    public static int goodNodes(TreeNode root) {
        TreeNode res = new TreeNode(0);
        Queue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        dfs(root, maxPriorityQueue, res);
        return res.val;
    }

    private static void dfs(TreeNode node, Queue<Integer> maxPriorityQueue, TreeNode res) {
        if (node == null)
            return;

        if (maxPriorityQueue.isEmpty() || maxPriorityQueue.element() <= node.val)
            res.val++;

        maxPriorityQueue.add(node.val);
        dfs(node.left, maxPriorityQueue, res);
        dfs(node.right, maxPriorityQueue, res);
        maxPriorityQueue.remove(node.val);
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
