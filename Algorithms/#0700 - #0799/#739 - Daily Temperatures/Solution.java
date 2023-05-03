import java.util.Arrays;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
 * <tt>answer[i]</tt> is the number of days you have to wait after the i<sup>th</sup> day to get a warmer temperature.
 * If there is no future day for which this is possible, keep <tt>answer[i] == 0</tt> instead.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= temperatures.length <= 10<sup>5</sup></tt></li>
 * <li><tt>30 <= temperatures[i] <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.05.2023
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));  // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 40, 50, 60 })));  // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 60, 90 })));  // [1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 })));  // [3,1,1,2,1,1,0,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 })));  // [8,1,5,4,3,2,1,1,0,0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                res[i] = 1;
            } else if (res[i + 1] == 0) {
                res[i] = 0;
            } else {
                int j = i + 1;

                while (temperatures[i] >= temperatures[j] && res[j] != 0) {
                    j += res[j];
                }

                res[i] = temperatures[i] < temperatures[j] ? j - i : 0;
            }
        }

        return res;
    }

}
