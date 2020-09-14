import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 13.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (true) {
            if (min == max || (nums[min] == target && nums[max] == target))
                break;
            if()



            int mid = (min + max) / 2;

            if (mid < target)
                max = mid - 1;
            else if()


        }

        if (min == max && min != target)
            return new int[] { -1, -1 };

        return new int[] { min, max };
    }

}
