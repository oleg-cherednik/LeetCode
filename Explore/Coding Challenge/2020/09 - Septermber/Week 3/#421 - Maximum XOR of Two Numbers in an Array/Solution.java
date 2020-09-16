/**
 * Given a <b>non-empty</b> array of numbers, <tt>a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, … , a<sub>n-1</sub></tt>, where <tt>0 ≤ ai <
 * 2<sup>31</sup></tt>.
 * <p>
 * Find the maximum result of <tt>a<sub>i</sub> XOR a<sub>j</sub></tt>, where <tt>0 ≤ i, j < n</tt>.
 * <p>
 * Could you do this in <tt>O(n)</tt> runtime?
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 16.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));   // 28
    }

    public static int findMaximumXOR(int[] nums) {
        TreeNode root = buildTree(nums);
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length && res < Integer.MAX_VALUE; i++) {
            TreeNode node = root;
            int max = 0;

            for (int mask = 1 << 30; mask > 0; mask >>= 1) {
                if ((nums[i] & mask) == 0) {
                    if (node.one == null)
                        node = node.zero;
                    else {
                        node = node.one;
                        max += mask;
                    }
                } else {
                    if (node.zero == null)
                        node = node.one;
                    else {
                        node = node.zero;
                        max += mask;
                    }
                }
            }

            res = Math.max(res, max);
        }

        return res;
    }

    private static TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode();

        for (int num : nums) {
            TreeNode node = root;

            // 31st bit is always zero (because of num >= 0)
            for (int mask = 1 << 30; mask > 0; mask >>= 1)
                node = node.getOrCreate((num & mask) == 0);
        }

        return root;
    }

    private static class TreeNode {

        private TreeNode zero;
        private TreeNode one;

        public TreeNode getOrCreate(boolean bit) {
            if (bit)
                return zero == null ? zero = new TreeNode() : zero;
            return one == null ? one = new TreeNode() : one;
        }
    }

}
