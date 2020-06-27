/**
 * Given an array of <b>unique</b> integers <tt>salary</tt> where <tt>salary[i]</tt> is the salary of the employee <tt>i</tt>.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: salary = [4000,3000,1000,2000]
 * Output: 2500.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
 * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: salary = [1000,2000,3000]
 * Output: 2000.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
 * Average salary excluding minimum and maximum salary is (2000)/1= 2000
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: salary = [6000,5000,4000,3000,2000,1000]
 * Output: 3500.00000
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: salary = [8000,9000,2000,3000,6000,1000]
 * Output: 4750.00000
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>3 <= salary.length <= 100</tt></li>
 * <li><tt>10<sup>3</sup> <= salary[i] <= 10<sup>6</sup></tt></li>
 * <li><tt>salary[i]</tt> is unique.</li>
 * <li>Answers within <tt>10<sup>-5</sup></tt> of the actual value will be accepted as correct.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 27.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(average(new int[] { 4000, 2000, 1000, 2000 }));              // 2000.0
        System.out.println(average(new int[] { 1000, 2000, 3000 }));                    // 2000.0
        System.out.println(average(new int[] { 6000, 5000, 4000, 3000, 2000, 1000 }));  // 3500.0
        System.out.println(average(new int[] { 8000, 9000, 2000, 3000, 6000, 1000 }));  // 4750.0
    }

    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int val : salary) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }

        return (sum - min - max) / (salary.length - 2.);
    }

}
