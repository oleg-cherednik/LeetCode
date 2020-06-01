/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly
 * once. Find this single element that appears only once.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 12.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));    // 2
        System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));       // 10
        System.out.println(singleNonDuplicate(new int[] { 1, 2, 2, 3, 3 }));                // 1

    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int i = 0;

        for (int j = nums.length - 1; i + 2 <= j; ) {
            if (i + 2 == j) {
                if (nums[i] == nums[i + 1])
                    i = j;
                else
                    j = i;
            } else {
                int k = (i + j) / 2;

                if (nums[k] == nums[k + 1])
                    k++;

                if ((k - i + 1) % 2 == 0)
                    i = k - 1;
                else
                    j = k;
            }
        }

        return nums[i];
    }

}
