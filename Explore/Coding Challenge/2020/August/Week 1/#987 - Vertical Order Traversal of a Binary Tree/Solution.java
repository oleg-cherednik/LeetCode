import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position <tt>(X, Y)</tt>, its left and right children respectively will be at positions <tt>(X-1,
 * Y-1)</tt> and <tt>(X+1, Y-1)</tt>.
 * <p>
 * Running a vertical line from <tt>X = -infinity</tt> to <tt>X = +infinity</tt>, whenever the vertical line touches
 * some nodes, we report the values of the nodes in order from top to bottom (decreasing <tt>Y</tt> coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of <tt>X</tt> coordinate. Every report will have a list of values of
 * nodes.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="1236_example_1.png" />
 * <pre>
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="tree2.png" />
 * <pre>
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The tree will have between <tt>1</tt> and <tt>1000</tt> nodes.</li>
 * <li>Each node's value will be between <tt>0</tt> and <tt>1000</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 07.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(verticalTraversal(3, 9, 20, null, null, 15, 7)); // [[9], [3, 15], [20], [7]]
        System.out.println(verticalTraversal(1, 2, 3, 4, 5, 6, 7));         // [[4], [2], [1, 5, 6], [3], [7]]
        System.out.println(verticalTraversal(0, 8, 1, null, null, 3, 2, null,
                4, 5, null, null, 7, 6));                       // [[8], [0, 3, 6], [1, 4, 5], [2, 7]]
        System.out.println(verticalTraversal(0, 2, 1, 3, null, null, null, 4,
                5, null, 7, 6, null, 10, 8, 11, 9));            // [[4, 10, 11], [3, 6, 7], [2, 5, 8, 9], [0], [1]]
        System.out.println(verticalTraversal(0, 5, 1, 9, null, 2, null, null,
                null, null, 3, 4, 8, 6, null, null, null, 7));  // [[9, 7], [5, 6], [0, 2, 4], [1, 3], [8]]
        System.out.println(verticalTraversal(0, 2, 1, 3, null, 5, 22, 9, 4, 12, 25, null,
                null, 13, 14, 8, 6, null, null, null, null, null, 27, 24, 26, null, 17, 7,
                null, 28, null, null, null, null, null, 19, null, 11, 10, null, null, null,
                23, 16, 15, 20, 18, null, null, null, null, null, 21, null, null, 29));
        // [[13, 28], [9, 24, 27, 16], [3, 8, 14, 11, 19], [2, 4, 12, 7, 17, 26, 15, 20, 23], [0, 5, 6, 10, 21, 29], [1, 25, 18], [22]]
    }

    private static List<List<Integer>> verticalTraversal(Integer... vals) {
        TreeNode root = build(vals);
        return verticalTraversal(root);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Point> minHeap = new PriorityQueue<>((one, two) -> {
            if (one.x == two.x)
                return one.y == two.y ? Integer.compare(one.val, two.val) : Integer.compare(two.y, one.y);
            return Integer.compare(one.x, two.x);
        });

        dfs(root, 0, 0, minHeap);

        Map<Integer, List<Integer>> map = new TreeMap<>();

        while (!minHeap.isEmpty()) {
            Point point = minHeap.remove();
            map.computeIfAbsent(point.x, x -> new ArrayList<>()).add(point.val);
        }

        return new ArrayList<>(map.values());
    }

    private static void dfs(TreeNode node, int x, int y, Queue<Point> minHeap) {
        if (node == null)
            return;

        minHeap.add(new Point(x, y, node.val));
        dfs(node.left, x - 1, y - 1, minHeap);
        dfs(node.right, x + 1, y - 1, minHeap);
    }

    private static class Point {

        final int x;
        final int y;
        final int val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
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

    }

}
