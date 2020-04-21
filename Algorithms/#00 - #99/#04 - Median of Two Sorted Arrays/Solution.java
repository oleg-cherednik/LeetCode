/**
 * There are two sorted arrays <b>nums1</b> and <b>nums2</b> of size <tt>m</tt> and <tt>n</tt> respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be <tt>O(log (m+n))</tt>.
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 19.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 2 }));    // 2.0
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })); // 2.5
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        boolean even = len % 2 == 0;
        int mid = len / 2;

        for (int i = 0, j = 0, k = 0, prv = 0; ; k++) {
            int val;

            if (i < nums1.length)
                val = j < nums2.length ? nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++] : nums1[i++];
            else if (j < nums2.length)
                val = nums2[j++];
            else
                throw new RuntimeException("illegal");

            if (k == mid)
                return even ? (val + prv) / 2.0 : val;

            prv = val;
        }
    }
}
