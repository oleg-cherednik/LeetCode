import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the array <tt>candies</tt> and the integer <tt>extraCandies</tt>, where <tt>candies[i]</tt> represents the number of candies that the
 * <b>ith</b> kid has.
 * <p>
 * For each kid check if there is a way to distribute <tt>extraCandies</tt> among the kids such that he or she can have the <b>greatest</b> number of
 * candies among them. Notice that multiple kids can have the <b>greatest</b> number of candies.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Explanation:
 * Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids.
 * Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
 * Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
 * Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: candies = [4,2,1,1,2], extraCandies = 1
 * Output: [true,false,false,false,false]
 * Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the
 * extra candy.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: candies = [12,1,12], extraCandies = 10
 * Output: [true,false,true]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= candies.length <= 100</tt></li>
 * <li><tt>1 <= candies[i] <= 100</tt></li>
 * <li><tt>1 <= extraCandies <= 50</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));    // [true, true, true, false, true]
        System.out.println(kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));    // [true, false, false, false, false]
        System.out.println(kidsWithCandies(new int[] { 12, 1, 12 }, 10));       // [true, false, true]
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0);
        List<Boolean> res = new ArrayList<>(candies.length);

        for (int candy : candies)
            res.add(candy + extraCandies >= max);

        return res;
    }
}
