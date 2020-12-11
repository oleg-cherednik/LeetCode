/**
 * Given an array of integers <tt>arr</tt>, return <i><tt>true</tt> if and only if it is a valid mountain array</i>.
 * <ul>
 * Recall that <tt>arr</tt> is a mountain array if and only if:
 * <li><tt>arr.length >= 3</tt></li>
 * <li>
 * There exists some i with 0 < i < arr.length - 1 such that:
 * <ul>
 * <li><tt>arr[0] < arr[1] < ... < arr[i - 1] < A[i]</tt></li>
 * <li><tt>arr[i] > arr[i + 1] > ... > arr[arr.length - 1]</tt></li>
 * </ul>
 * </li>
 * </ul>
 * <p>
 * <img src="hint_valid_mountain_array.png" />
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: arr = [2,1]
 * Output: false
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: arr = [3,5,5]
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: arr = [0,3,2,1]
 * Output: true
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 10<sup>4</sup></tt></li>
 * <li><tt>0 <= arr[i] <= 10<sup>4</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 11.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(validMountainArray(new int[] { 2, 1 }));                     // false
        System.out.println(validMountainArray(new int[] { 3, 5, 5 }));                  // false
        System.out.println(validMountainArray(new int[] { 0, 3, 2, 1 }));               // true
        System.out.println(validMountainArray(new int[] { 0, 2, 3, 4, 5, 2, 1, 0 }));   // true
        System.out.println(validMountainArray(new int[] { 0, 2, 3, 3, 5, 2, 1, 0 }));   // false
    }

    public static boolean validMountainArray(int[] arr) {
        Boolean rise = null;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i])
                return false;

            if (rise == null) {
                if (arr[i - 1] < arr[i])
                    rise = Boolean.TRUE;
                else
                    return false;
            } else if (rise) {
                if (arr[i - 1] > arr[i])
                    rise = Boolean.FALSE;
            } else if (arr[i - 1] < arr[i])
                return false;
        }

        return rise == Boolean.FALSE;
    }
}
