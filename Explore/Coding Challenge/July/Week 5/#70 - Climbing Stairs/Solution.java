/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <b>Note:</b> Given <tt>n</tt> will be a positive integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(climbStairs(1));     // 1
        System.out.println(climbStairs(2));     // 2
        System.out.println(climbStairs(3));     // 3
        System.out.println(climbStairs(44));    // 1134903170
    }

    public static int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;

        if (n > 1)
            arr[2] = 2;

        for (int i = 3; i < arr.length; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n];
    }

}
