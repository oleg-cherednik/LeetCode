import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [10,2]
 * Output: "210"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * </pre>
 * <b>Note:</b> The result may be very large, so you need to return a string instead of an integer.
 *
 * @author Oleg Cherednik
 * @since 26.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestNumber(new int[] { 10, 2 }));             // 210
        System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));   // 9534330
        System.out.println(largestNumber(new int[] { 0, 0 }));              // 0
    }

    public static String largestNumber(int[] nums) {
        String str = Arrays.stream(nums)
                           .mapToObj(String::valueOf)
                           .sorted((one, two) -> (two + one).compareTo(one + two))
                           .collect(Collectors.joining());

        return str.charAt(0) == '0' ? "0" : str;
    }
}
