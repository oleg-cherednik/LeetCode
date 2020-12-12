import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <ul>
 * Implement the <tt>BSTIterator</tt> class that represents an iterator over the <a href="https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR)">
 * <b>in-order traversal</b></a> of a binary search tree (BST):
 * <li><tt>BSTIterator(TreeNode root)</tt> Initializes an object of the <tt>BSTIterator</tt> class. The <tt>root</tt> of the BST is given as part of
 * the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.</li>
 * <li><tt>boolean hasNext()</tt> Returns <tt>true</tt> if there exists a number in the traversal to the right of the pointer, otherwise returns
 * <tt>false</tt>.</li>
 * <li><tt>int next()</tt> Moves the pointer to the right, then returns the number at the pointer.</li>
 * </ul>
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to <tt>next()</tt> will return the smallest element in
 * the BST.
 * <p>
 * You may assume that <tt>next()</tt> calls will always be valid. That is, there will be at least a next number in the in-order traversal when
 * <tt>next()</tt> is called.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="bst-tree.png" />
 * <pre>
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is in the range <tt>[1, 10<sup>5</sup>]</tt>.</li>
 * <li><tt>0 <= Node.val <= 10<sup>6</sup></tt></li>
 * <li>At most <tt>10<sup>5</sup></tt> calls will be made to <tt>hasNext</tt>, and <tt>next</tt>.</li>
 * </ul>
 * <ul>
 * <b>Follow up:</b>
 * <li>Could you implement <tt>next()</tt> and <tt>hasNext()</tt> to run in average <tt>O(1)</tt> time and use <tt>O(h)</tt> memory, where <tt>h</tt>
 * is the height of the tree?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.12.2020
 */
public class Solution {

    public static void main(String... args) {
        TreeNode root = build(7, 3, 15, null, null, 9, 20);
        BSTIterator it = new BSTIterator(root);
        System.out.println(it.next());      // 3
        System.out.println(it.next());      // 7
        System.out.println(it.hasNext());   // true
        System.out.println(it.next());      // 9
        System.out.println(it.hasNext());   // true
        System.out.println(it.next());      // 15
        System.out.println(it.hasNext());   // true
        System.out.println(it.next());      // 20
        System.out.println(it.hasNext());   // false
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

        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static class BSTIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            if (root != null)
                stack.push(root);
            findMin();
        }

        private void findMin() {
            while (!stack.isEmpty() && stack.element().left != null) {
                stack.push(stack.element().left);
            }
        }

        public int next() {
            if (!hasNext())
                throw new RuntimeException();

            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
                findMin();
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
