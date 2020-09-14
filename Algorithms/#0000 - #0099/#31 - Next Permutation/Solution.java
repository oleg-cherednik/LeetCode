import java.util.Arrays;

/**
 * Implement <b>next permutation</b>, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be <b>in-place</b> and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * <pre>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 29.04.2020
 */
public class Solution {

    public static void main(String... args) {
//        nextPermutationAndPrint(1, 2, 3);   // [1, 3, 4]
//        nextPermutationAndPrint(3, 2, 1);   // [1, 2, 3]
//        nextPermutationAndPrint(1, 1, 5);   // [1, 5, 1]

        nextPermutationAndPrint(1, 3, 2);   // [2, 1, 3]
    }

    private static void nextPermutationAndPrint(int... nums) {
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1])
                continue;

            swap(nums, i, i + 1);

            for (int j = i + 2, k = nums.length - 1; j < k; j++, k--)
                swap(nums, j, k);

            return;
        }

        for (int j = 0, k = nums.length - 1; j < k; j++, k--)
            swap(nums, j, k);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
