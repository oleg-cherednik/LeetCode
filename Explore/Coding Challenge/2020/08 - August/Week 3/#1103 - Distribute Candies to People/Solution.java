import java.util.Arrays;

/**
 * We distribute some number of <tt>candies</tt>, to a row of <tt>n = num_people</tt> people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give <tt>n</tt> candies
 * to the last person.
 * <p>
 * Then, we go back to the start of the row, giving <tt>n + 1</tt> candies to the first person, <tt>n + 2</tt> candies
 * to the second person, and so on until we give <tt>2 * n</tt> candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the
 * end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one
 * more than the previous gift).
 * <p>
 * Return an array (of length <tt>num_people</tt> and sum <tt>candies</tt>) that represents the final distribution of
 * candies.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= candies <= 10<sup>9</sup></tt></li>
 * <li><tt>1 <= num_people <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 17.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));   // [1, 2, 3, 1]
        System.out.println(Arrays.toString(distributeCandies(10, 3)));  // [5, 2, 3]
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];

        for (int i = 0, j = 1; candies > 0; i = ++i == res.length ? 0 : i, j++) {
            res[i] += Math.min(candies, j);
            candies -= j;
        }

        return res;
    }

}
