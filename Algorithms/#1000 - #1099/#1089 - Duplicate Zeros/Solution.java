import java.util.Arrays;

/**
 * Given a fixed length array <tt>arr</tt> of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array <b>in place</b>, do not return anything from your function.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * </pre>
 * <ol>
 * Note:
 * <p>
 * <li><tt>1 <= arr.length <= 10000</tt></li>
 * <li><tt>0 <= arr[i] <= 9</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 14.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(duplicateZerosStr(1, 0, 2, 3, 0, 4, 5, 0));  // [1, 0, 0, 2, 3, 0, 0, 4]
        System.out.println(duplicateZerosStr(1, 2, 3));                 // [1, 2, 3]
        System.out.println(duplicateZerosStr(0, 0, 0, 0, 0, 0, 0));     // [0, 0, 0, 0, 0, 0, 0]
        System.out.println(duplicateZerosStr(8, 4, 5, 0, 0, 0, 0, 7));  // [8, 4, 5, 0, 0, 0, 0, 0]
    }

    private static String duplicateZerosStr(int... arr) {
        duplicateZeros(arr);
        return Arrays.toString(arr);
    }

    public static void duplicateZeros(int[] arr) {
        int i = 0;
        int len = 0;

        for (; i < arr.length && len < arr.length; i++, len++)
            if (arr[i] == 0)
                len++;

        if (i == arr.length || i == 0)
            return;

        i--;

        boolean twoZero = len == arr.length;

        for (int j = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[j--] = 0;

                if (twoZero)
                    arr[j--] = 0;

                twoZero = true;
            } else
                arr[j--] = arr[i];
        }
    }
}
