import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of integers <tt>arr</tt> and an integer <tt>k</tt>. Find the <li>least number of unique integers</li> after removing <b>exactly</b>
 * <tt>k</tt> elements.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 10<sup>5</sup></tt></li>
 * <li><tt>1 <= arr[i] <= 10<sup>9</sup></tt></li>
 * <li><tt>0 <= k <= arr.length</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLeastNumOfUniqueInts(new int[] { 5, 5, 4 }, 1));             // 1
        System.out.println(findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3)); // 2
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : arr)
            map.put(val, map.getOrDefault(val, 0) + 1);

        Queue<Integer> queue = new PriorityQueue<>(map.values());

        while (k > 0 && !queue.isEmpty()) {
            int count = queue.remove();

            if (count > k)
                queue.add(count - k);

            k -= count;
        }

        return queue.size();
    }

}
