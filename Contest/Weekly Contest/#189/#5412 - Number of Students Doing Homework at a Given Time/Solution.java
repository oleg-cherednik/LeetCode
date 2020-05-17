/**
 * Given two integer arrays <tt>startTime</tt> and <tt>endTime</tt> and given an integer <tt>queryTime.</tt>
 * <p>
 * The <tt>ith</tt> student started doing their homework at the time <tt>startTime[i]</tt> and finished it at time <tt>endTime[i]</tt>.
 * <p>
 * Return <i>the number of students</i> doing their homework at time <tt>queryTime</tt>. More formally, return the number of students where
 * <tt>queryTime</tt> lays in the interval <tt>[startTime[i], endTime[i]]</tt> inclusive.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Output: 1
 * Explanation: We have 3 students where:
 * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
 * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
 * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: startTime = [4], endTime = [4], queryTime = 4
 * Output: 1
 * Explanation: The only student was doing their homework at the queryTime.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: startTime = [4], endTime = [4], queryTime = 5
 * Output: 0
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * Output: 0
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
 * Output: 5
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>startTime.length == endTime.length
 * <li><tt>1 <= startTime.length <= 100</tt></li>
 * <li><tt>1 <= startTime[i] <= endTime[i] <= 1000</tt></li>
 * <li><tt>1 <= queryTime <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(busyStudent(new int[] { 1, 2, 3 }, new int[] { 3, 2, 7 }, 4));       // 1
        System.out.println(busyStudent(new int[] { 4 }, new int[] { 4 }, 4));                   // 1
        System.out.println(busyStudent(new int[] { 4 }, new int[] { 4 }, 5));                   // 0
        System.out.println(busyStudent(new int[] { 1, 1, 1, 1 }, new int[] { 1, 3, 2, 4 }, 7)); // 0
        System.out.println(busyStudent(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 5));  // 5
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;

        for (int i = 0; i < startTime.length; i++)
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                res++;

        return res;
    }
}
