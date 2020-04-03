/**
 * Given an integer array <tt>nums</tt>, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> [2,3,-2,4]
 * <b>Output:</b> 6
 * <b>Explanation:</b> [2,3] has the largest product 6.
 * </pre>
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> [-2,0,-1]
 * <b>Output:</b> 0
 * <b>Explanation:</b> The result cannot be 2, because [-2,-1] is not a subarray.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
        System.out.println(maxProduct(new int[] { -2, 0, -1 }));
    }

    public static int maxProduct(int[] nums) {

    }
}
