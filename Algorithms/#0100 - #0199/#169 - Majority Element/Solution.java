import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size <tt>n</tt>, find the majority element. The majority element is the element that appears <b>more than</b> <tt>⌊ n/2 ⌋</tt>
 * times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [3,2,3]
 * Output: 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(majorityElement(new int[] { 3, 2, 3 }));             // 3
        System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 })); // 2
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);

            if (count + 1 > nums.length / 2)
                return nums[i];

            map.put(nums[i], count + 1);
        }

        return -1;
    }

}
