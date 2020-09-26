/**
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking
 * <b>ascending</b> time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in
 * poisoned condition.
 * <p>
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,4], 2
 *
 * Output: 4
 *
 * Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 * This poisoned status will last 2 seconds until the end of time point 2.
 * And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 * So you finally need to output 4.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,2], 2
 *
 * Output: 3
 *
 * Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
 * This poisoned status will last 2 seconds until the end of time point 2.
 * However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
 * Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of
 * time point 3.
 * So you finally need to output 3.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>You may assume the length of given time series array won't exceed <tt>10000</tt>.</li>
 * <li>You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which
 * won't exceed <tt>10,000,000</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 26.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findPoisonedDuration(new int[] { 1, 4 }, 2));            // 4
        System.out.println(findPoisonedDuration(new int[] { 1, 2 }, 2));            // 3
        System.out.println(findPoisonedDuration(new int[] { 1, 2, 3, 4, 5 }, 5));   // 9
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int max = 0;

        for (int time : timeSeries) {
            res += duration + Math.min(0, time - max);
            max = time + duration;
        }

        return res;
    }

}
