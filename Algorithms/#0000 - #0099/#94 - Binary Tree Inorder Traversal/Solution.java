import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the <tt>root</tt> of a binary tree, return <i>the inorder traversal of its nodes' values</i>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="untitled-diagram-2.jpg" />
 * <pre>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: root = []
 * Output: []
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: root = [1]
 * Output: [1]
 * </pre>
 * <b>Example 4:</b>
 * <p>
 * <img src="untitled-diagram-4.jpg" />
 * <pre>
 * Input: root = [1,2]
 * Output: [2,1]
 * </pre>
 * <b>Example 5:</b>
 * <p>
 * <img src="untitled-diagram-5.jpg" />
 * <pre>
 * Input: root = [1,null,2]
 * Output: [1,2]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is in the range <tt>[0, 100]</tt>.</li>
 * <li><tt>-100 <= Node.val <= 100</tt></li>
 * </ul>
 * <p>
 * <b>Follow up:</b>
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 *
 * @author Oleg Cherednik
 * @since 12.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(inorderTraversal(1, null, 2, 3));        // [1, 3, 2]
        System.out.println(inorderTraversal());                     // []
        System.out.println(inorderTraversal(1));                    // [1]
        System.out.println(inorderTraversal(1, 2));                 // [2, 1]
        System.out.println(inorderTraversal(4, 2, 6, 1, 3, 5, 7));  // [1, 2, 3, 4, 5, 6, 7]
    }

    private static List<Integer> inorderTraversal(Integer... vals) {
        TreeNode root = build(vals);
        return inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        findBottomLeft(stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
                findBottomLeft(stack);
            }
        }

        return res;
    }

    private static void findBottomLeft(Deque<TreeNode> stack) {
        while (!stack.isEmpty() && stack.element().left != null) {
            stack.push(stack.element().left);
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
