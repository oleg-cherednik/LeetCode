/**
 * You are driving a vehicle that has <tt>capacity</tt> empty seats initially available for passengers. The vehicle <b>only</b> drives east (ie. it
 * <b>cannot</b> turn around and drive west.)
 * <p>
 * Given a list of <tt>trips</tt>, <tt>trip[i] = [num_passengers, start_location, end_location]</tt> contains information about the <tt>i-th</tt>
 * trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number
 * of kilometers due east from your vehicle's initial location.
 * <p>
 * Return <tt>true</tt> if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 * </pre>
 * <ol>
 * <b>Constraints:</b>
 * <li><tt>trips.length <= 1000</tt></li>
 * <li><tt>trips[i].length == 3</tt></li>
 * <li><tt>1 <= trips[i][0] <= 100</tt></li>
 * <li><tt>0 <= trips[i][1] < trips[i][2] <= 1000</tt></li>
 * <li><tt>1 <= capacity <= 100000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 21.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));                // false
        System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));                // true
        System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 3));                // true
        System.out.println(carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11));  // true
        System.out.println(carPooling(new int[][] { { 10, 5, 7 }, { 10, 3, 4 }, { 7, 1, 8 }, { 6, 3, 4 } }, 24));  // true
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] trip : trips) {
            locations[trip[1]] += trip[0];
            locations[trip[2]] -= trip[0];
            min = Math.min(min, trip[1]);
            max = Math.max(max, trip[2]);
        }

        for (int i = min, cur = 0; i <= max; i++)
            if ((cur += locations[i]) > capacity)
                return false;

        return true;
    }

}
