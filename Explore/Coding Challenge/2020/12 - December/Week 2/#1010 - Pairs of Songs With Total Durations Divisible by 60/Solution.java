import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of songs where the <tt>i<sup>th</sup></tt> song has a duration of <tt>time[i]</tt> seconds.
 * <p>
 * Return <i>the number of pairs of songs for which their total duration in seconds is divisible by <tt>60</tt></i>. Formally, we want the number of
 * indices <tt>i</tt>, <tt>j</tt> such that <tt>i < j</tt> with <tt>(time[i] + time[j]) % 60 == 0</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= time.length <= 6 * 10<sup>4</sup></tt></li>
 * <li><tt>1 <= time[i] <= 500</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 09.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));  // 3
        System.out.println(numPairsDivisibleBy60(new int[] { 60, 60, 60 }));            // 3
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Arrays.sort(time);

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            for (int i = (int)Math.ceil(t / 60.) * 60; i <= 2 * t; i += 60)
                if (map.containsKey(i - t))
                    res += map.get(i - t);

            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        return res;
    }

}
