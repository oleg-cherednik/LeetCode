import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * Given an integer array <tt>nums</tt>, design an algorithm to randomly shuffle the array. All permutations of the
 * array should be <b>equally likely</b> as a result of the shuffling.
 * <p>
 * <ul>
 * Implement the <tt>Solution</tt> class:
 * <li><tt>Solution(int[] nums)</tt> Initializes the object with the integer array <tt>nums</tt>.</li>
 * <li><tt>int[] reset()</tt> Resets the array to its original configuration and returns it.</li>
 * <li><tt>int[] shuffle()</tt> Returns a random shuffling of the array.</li>
 * </ul>
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 50</tt></li>
 * <li><tt>-10<sup>6</sup> <= nums[i] <= 10<sup>6</sup></tt></li>
 * <li>All the elements of nums are <b>unique</b>.</li>
 * <li>At most <tt>10<sup>4</sup></tt> calls <b>in total</b> will be made to <tt>reset</tt> and <tt>shuffle</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 01.10.2022
 */
public class Solution {

    public static void main(String... args) {
        Solution solution = new Solution(new int[] { 1, 2, 3 });
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));  // [1, 2, 3]
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }

    public int[] shuffle() {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(i -> i).toArray();
    }

}

