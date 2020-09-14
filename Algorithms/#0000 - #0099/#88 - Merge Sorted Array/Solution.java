import java.util.Arrays;

/**
 * Given two sorted integer arrays <tt>nums1</tt> and <tt>nums2</tt>, merge <tt>nums2</tt> into <tt>nums1</tt> as one sorted array.
 * <p>
 * <ul>
 * <b>Note:</b>
 * <li>The number of elements initialized in <tt>nums1</tt> and <tt>nums2</tt> are <tt>m</tt> and <tt>n</tt> respectively.</li>
 * <li>You may assume that <tt>nums1</tt> has enough space (size that is greater or equal to <tt>m + n</tt>) to hold additional elements from <tt>nums2</tt>.</li>
 * </ul>
 * <b>Example:</b>
 * <pre>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        mergeAndPrint(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3); // [1, 2, 2, 3, 5, 6]
        mergeAndPrint(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3); // [1, 2, 3, 4, 5, 6]
    }

    private static void mergeAndPrint(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
