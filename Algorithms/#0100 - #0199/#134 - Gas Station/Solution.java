/**
 * There are <tt>N</tt> gas stations along a circular route, where the amount of gas at station <tt>i</tt> is <tt>gas[i]</tt>.
 * <p>
 * You have a car with an unlimited gas tank and it costs <tt>cost[i]</tt> of gas to travel from station <tt>i</tt> to its next station
 * <tt>(i+1)</tt>. You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return <tt>-1</tt>.
 * <ul>
 * <b>Note:</b>
 * <li>If there exists a solution, it is guaranteed to be unique.</li>
 * <li>Both input arrays are non-empty and have the same length.</li>
 * <li>Each element in the input arrays is a non-negative integer.</li>
 * </ol>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * Output: 3
 *
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * Output: -1
 *
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));   // 3
        System.out.println(canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));               // -1
        System.out.println(canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 }));   // 4
        System.out.println(canCompleteCircuit(new int[] { 5, 8, 2, 8 }, new int[] { 6, 5, 6, 6 }));         // 3
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = gas[0] - cost[0];
        int min = gas[0] - cost[0];
        int minIndex = 0;

        for (int i = 1; i < gas.length; i++) {
            balance += gas[i] - cost[i];

            if (balance < min) {
                min = balance;
                minIndex = i;
            }
        }

        if (balance < 0)
            return -1;

        return minIndex + 1 == gas.length ? 0 : minIndex + 1;
    }

}
