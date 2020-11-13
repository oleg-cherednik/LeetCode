import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree
 * <pre>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * </pre>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to <tt>NULL</tt>.
 * <p>
 * Initially, all next pointers are set to <tt>NULL</tt>.
 * <ul>
 * <b>Follow up:</b>
 * <li>You may only use constant extra space.</li>
 * <li>Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="117_sample.png.png" />
 * <pre>
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the given tree is less than <tt>6000</tt>.</li>
 * <li><tt>-100 <= node.val <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(connect(1, 2, 3, 4, 5, null, 7));   // [1,#,2,3,#,4,5,7,#]
        System.out.println(connect());
    }

    private static List<String> connect(Integer... vals) {
        Node root = build(vals);
        root = connect(root);

        List<String> res = new ArrayList<>();
        Queue<Node> nodes = new LinkedList<>();

        if (root != null)
            nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            if (node.left != null)
                nodes.add(node.left);

            while (node != null) {
                res.add(String.valueOf(node.val));
                node = node.next;
            }

            res.add("#");
        }

        return res;
    }

    public static Node connect(Node root) {
        Queue<Node> nodes = new LinkedList<>();

        if (root != null)
            nodes.add(root);

        while (!nodes.isEmpty()) {
            Node prv = null;

            for (int i = 0, total = nodes.size(); i < total; i++) {
                Node node = nodes.remove();

                if (prv != null)
                    prv.next = node;

                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);

                prv = node;
            }
        }

        return root;
    }

    private static Node build(Integer... vals) {
        Node root = null;
        Queue<Node> nodes = new LinkedList<>();

        for (int i = 0; i < vals.length; ) {
            if (i == 0)
                nodes.add(root = new Node(vals[i++]));
            else {
                if (nodes.isEmpty())
                    break;

                Integer left = vals[i++];
                Integer right = i < vals.length ? vals[i++] : null;
                Node node = nodes.remove();

                if (left != null)
                    nodes.add(node.left = new Node(left));
                if (right != null)
                    nodes.add(node.right = new Node(right));
            }
        }

        return root;
    }

    public static class Node {

        int val;
        Node left;
        Node right;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}
