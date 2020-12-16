import java.util.Arrays;

/**
 * Given an array of integers <tt>A</tt> sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing
 * order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= A.length <= 10000</tt></li>
 * <li><tt>-10000 <= A[i] <= 10000</tt></li>
 * <li><tt>A</tt> is sorted in non-decreasing order.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));  // [0, 1, 9, 16, 100]
        System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));  // [4, 9, 9, 49, 121]
    }

    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];

        for (int i = A.length, l = 0, r = A.length - 1; l <= r; i--) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                res[i - 1] = A[l] * A[l];
                l++;
            } else {
                res[i - 1] = A[r] * A[r];
                r--;
            }
        }

        return res;
    }

}
