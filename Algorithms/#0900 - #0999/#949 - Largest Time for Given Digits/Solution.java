import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3,4]
 * Output: "23:41"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [5,5,5,5]
 * Output: ""
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>A.length == 4</tt></li>
 * <li><tt>0 <= A[i] <= 9</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 01.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));    // 23:41
        System.out.println(largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));    // ""
        System.out.println(largestTimeFromDigits(new int[] { 0, 4, 0, 0 }));    // 04:00
        System.out.println(largestTimeFromDigits(new int[] { 2, 0, 6, 6 }));    // 06:26
    }

    public static String largestTimeFromDigits(int[] A) {
        Set<String> res = permute(A, 0, new TreeSet<>(Comparator.reverseOrder()));
        return res.isEmpty() ? "" : res.iterator().next();
    }

    private static Set<String> permute(int[] arr, int k, Set<String> res) {
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1, res);
            swap(arr, k, i);
        }

        if (k == arr.length - 1)
            if (isValid(arr))
                res.add(convert(arr));

        return res;
    }

    private static String convert(int[] arr) {
        return String.format("%02d:%02d", arr[0] * 10 + arr[1], arr[2] * 10 + arr[3]);
    }

    private static boolean isValid(int[] arr) {
        if (arr[0] > 2)
            return false;
        if (arr[0] == 2 && arr[1] > 3)
            return false;
        return arr[2] <= 5;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
