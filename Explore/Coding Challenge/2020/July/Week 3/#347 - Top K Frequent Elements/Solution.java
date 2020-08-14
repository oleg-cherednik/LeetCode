import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a non-empty array of integers, return the <b>k</b> most frequent elements.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1], k = 1
 * Output: [1]
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>You may assume <tt>k</tt> is always valid, <tt>1 ≤ k ≤ number</tt> of unique elements.</li>
 * <li>Your algorithm's time complexity <b>must be better</b> than <tt>O(n log n)</tt>, where <tt>n</tt> is the array's size.</li>
 * <li>It's guaranteed that the answer is unique, in other words the set of the top <tt>k</tt> frequent elements is unique.</li>
 * <li>You can return the answer in any order.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));   // [1, 2]
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));                  // [1]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Queue<Map.Entry<Integer, Long>> queue =
                new PriorityQueue<>(Comparator.comparing((Function<Map.Entry<Integer, Long>, Long>)Map.Entry::getValue).reversed());
        queue.addAll(map.entrySet());
        return IntStream.range(0, k).map(i -> queue.remove().getKey()).toArray();
    }
}
