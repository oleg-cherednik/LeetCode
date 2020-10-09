import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted
 * across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a <b>binary search tree</b>. There is no restriction on how your serialization/deserialization
 * algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the
 * original tree structure.
 * <p>
 * <b>The encoded string should be as compact as possible.</b>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: root = []
 * Output: []
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is in the range <tt>[0, 10<sup>4</sup>]</tt>.</li>
 * <li><tt>0 <= Node.val <= 10<sup>4</sup></tt></li>
 * <li>The input tree is <b>guaranteed</b> to be a binary search tree.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 09.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(test(2, 1, 3));                                              // [2, 1, 3]
        System.out.println(test());                                                     // []
        System.out.println(test(8, 4, 12, 2, 6, 10, 14, null,
                3, 5, 7, 9, 11, 13, 15));                   // [8, 4, 12, 2, 6, 10, 14, null, 3, 5, 7, 9, 11, 13, 15]
        System.out.println(test(8, 4, 12, 2, 6, 10, 14, 1,
                null, null, null, null, null, null, 15));   // [8, 4, 12, 2, 6, 10, 14, 1, null, null, null, null, null, null, 15]
    }

    private static List<Integer> test(Integer... vals) {
        TreeNode root = build(vals);
        Codec ser = new Codec();
        String tree = ser.serialize(root);
        TreeNode ans = ser.deserialize(tree);

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(ans);

        while (!queue.isEmpty()) {
            int total = queue.size();
            List<Integer> row = new ArrayList<>();
            boolean empty = true;

            for (int i = 0; i < total; i++) {
                TreeNode node = queue.remove();

                if (node == null)
                    row.add(null);
                else {
                    empty = false;
                    row.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!empty)
                res.addAll(row);
        }

        return res;
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            StringBuilder buf = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int total = queue.size();
                boolean hasNext = false;
                List<Integer> row = new ArrayList<>();

                for (int i = 0; i < total; i++) {
                    TreeNode node = queue.poll();

                    if (node == null)
                        continue;

                    hasNext = true;
                    row.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }

                if (!hasNext)
                    break;

                for (Integer val : row) {
                    if (buf.length() > 0)
                        buf.append(' ');
                    buf.append(val);
                }
            }

            return buf.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty())
                return null;

            int[] arr = Arrays.stream(data.split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

            TreeNode root = null;

            for (int val : arr) {
                if (root == null)
                    root = new TreeNode(val);
                else
                    insertIntoBst(val, root, null);
            }

            return root;
        }

        private static void insertIntoBst(int val, TreeNode node, TreeNode parent) {
            if (node == null) {
                if (val < parent.val)
                    parent.left = new TreeNode(val);
                else
                    parent.right = new TreeNode(val);
            } else
                insertIntoBst(val, val < node.val ? node.left : node.right, node);
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

        TreeNode(int val) {
            this.val = val;
        }
    }

}
