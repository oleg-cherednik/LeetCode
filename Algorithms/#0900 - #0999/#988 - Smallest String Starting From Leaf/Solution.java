import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given the <tt>root</tt> of a binary tree where each node has a value in the range <tt>[0, 25]</tt>
 * representing the letters <tt>'a'</tt> to <tt>'z'</tt>.
 * <p>
 * Return <i>the <b>lexicographically smallest</b> string that starts at a leaf of this tree and ends at the root</i>.
 * <p>
 * As a reminder, any shorter prefix of a string is <b>lexicographically smaller</b>.
 * <ul>
 * <li>For example, <tt>"ab"</tt> is lexicographically smaller than <tt>"aba"</tt>.</li>
 * </ul>
 * A leaf of a node is a node that has no children.<p>
 * <b>Example 1:</b>
 * <p>
 * <img src="tree1.png.png" />
 * <pre>
 * Input: root = [0,1,2,3,4,3,4]
 * Output: "dba"
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="tree2.png" />
 * <pre>
 * Input: root = [25,1,3,1,3,0,2]
 * Output: "adz"
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="tree3.png" />
 * <pre>
 * Input: root = [2,2,1,null,1,0,null,0]
 * Output: "abc"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the tree is in the range <tt>[1, 8500]</tt>.</li>
 * <li><tt>0 <= Node.val <= 25</tt></li>
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 04.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(smallestFromLeaf(build(0, 1, 2, 3, 4, 5, 6)));           // dba
        System.out.println(smallestFromLeaf(build(25, 1, 3, 1, 3, 0, 2)));          // adz
        System.out.println(smallestFromLeaf(build(2, 2, 1, null, 1, 0, null, 0)));  // abc
    }

    public static String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, new LinkedList<>(), new TreeSet<>()).iterator().next();
    }

    private static Set<String> smallestFromLeaf(TreeNode parent, Deque<Character> stack, TreeSet<String> res) {
        if (parent == null)
            return res;

        stack.push((char)('a' + parent.val));

        if (parent.left == null && parent.right == null)
            res.add(createString(stack));

        smallestFromLeaf(parent.left, stack, res);
        smallestFromLeaf(parent.right, stack, res);

        stack.pop();

        return res;
    }

    private static String createString(Deque<Character> stack) {
        StringBuilder buf = new StringBuilder();

        for (char ch : stack)
            buf.append(ch);

        return buf.toString();
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
