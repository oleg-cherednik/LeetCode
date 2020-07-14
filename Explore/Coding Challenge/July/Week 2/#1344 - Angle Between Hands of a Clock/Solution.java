/**
 * Given two numbers, <tt>hour</tt> and <tt>minutes</tt>. Return the smaller angle (in degrees) formed between the <tt>hour</tt> and the
 * <tt>minute</tt> hand.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="sample_1_1673.png" />
 * <pre>
 * Input: hour = 12, minutes = 30
 * Output: 165
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="sample_2_1673.png" />
 * <pre>
 * Input: hour = 3, minutes = 30
 * Output: 75
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: hour = 4, minutes = 50
 * Output: 155
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: hour = 12, minutes = 0
 * Output: 0
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= hour <= 12</tt></li>
 * <li><tt>0 <= minutes <= 59</tt></li>
 * <li>Answers within <tt>10<sup>-5</sup></tt> of the actual value will be accepted as correct.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 15.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(angleClock(12, 30)); // 165.00
        System.out.println(angleClock(3, 30));  // 75
        System.out.println(angleClock(3, 15));  // 7.5
        System.out.println(angleClock(4, 50));  // 155
        System.out.println(angleClock(12, 0));  // 0.0
    }

    public static double angleClock(int hour, int minutes) {
        double hourDegree = hour * 30 % 360 + minutes * 0.5;
        double minuteDegree = minutes * 6;
        double answer = Math.abs(minuteDegree - hourDegree);
        return Math.min(answer, 360 - answer);
    }

}
