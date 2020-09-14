import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of <i>every</i> node never
 * differ by more than 1.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(sortedArrayToBSTString(1, 2, 3, 4, 5, 6, 7));    // [4, 2, 6, 1, 3, 5, 7]
        System.out.println(sortedArrayToBSTString(-10, -3, 0, 5, 9));       // [0, -10, 5, null, -3, null, 9]
    }

    private static List<Integer> sortedArrayToBSTString(int... nums) {
        TreeNode root = sortedArrayToBST(nums);
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> row = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            row.clear();
            boolean empty = true;

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.remove();
                res.add(node == null ? null : node.val);

                if (node == null) {
                    row.add(null);
                    row.add(null);
                } else {
                    empty &= node.left == null;
                    empty &= node.right == null;
                    row.add(node.left);
                    row.add(node.right);
                }
            }

            if (!empty)
                nodes.addAll(row);
        }

        return res;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1, null);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int i, int j, TreeNode parent) {
        if (i == j) {
            TreeNode node = new TreeNode(nums[i]);

            if (parent == null)
                parent = node;
            else if (node.val < parent.val)
                parent.left = node;
            else
                parent.right = node;
        } else if (i < j) {
            int m = (i + j) / 2;
            TreeNode node = new TreeNode(nums[m]);

            if (parent == null) {
                parent = node;
            } else if (node.val < parent.val)
                parent.left = node;
            else
                parent.right = node;

            sortedArrayToBST(nums, i, m - 1, node);
            sortedArrayToBST(nums, m + 1, j, node);
        }

        return parent;
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
