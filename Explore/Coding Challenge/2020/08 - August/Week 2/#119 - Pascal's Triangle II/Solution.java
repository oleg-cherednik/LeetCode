import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where <tt>k ≤ 33</tt>, return the <tt>k<sup>th</sup></tt> index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from <tt>0</tt>.
 * <p>
 * <img src="PascalTriangleAnimated2.gif" />
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 3
 * Output: [1,3,3,1]
 * </pre>
 * <b>Follow up:</b><br>
 * Could you optimize your algorithm to use only <tt>O(k)</tt> extra space?
 *
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getRow(0));  // [1]
        System.out.println(getRow(1));  // [1, 1]
        System.out.println(getRow(2));  // [1, 2, 1]
        System.out.println(getRow(3));  // [1, 3, 3, 1]
        System.out.println(getRow(4));  // [1, 4, 6, 4, 1]
        System.out.println(getRow(5));  // [1, 5, 10, 10, 5, 1]
        System.out.println(getRow(6));  // [1, 6, 15, 20, 15, 6, 1]
        System.out.println(getRow(13)); // [1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1]

    }

    public static List<Integer> getRow(int rowIndex) {
        int[] arr1 = new int[(int)Math.ceil((rowIndex + 1) / 2.)];
        int[] arr2 = new int[arr1.length];
        arr1[0] = 1;

        int[] arr = arr1;

        for (int i = 1; i <= rowIndex; i++) {
            boolean even = i % 2 == 0;
            arr = even ? arr1 : arr2;
            int[] prv = even ? arr2 : arr1;

            for (int j = 0; j <= i && j < arr.length; j++)
                arr[j] = get(prv, j - 1) + get(prv, j);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
            res.add(arr[i]);

        if (rowIndex > 0)
            for (int i = arr.length - (rowIndex % 2 == 0 ? 2 : 1); i >= 0; i--)
                res.add(arr[i]);

        return res;
    }

    private static int get(int[] arr, int i) {
        return i < 0 || i >= arr.length ? 0 : arr[i];
    }

}
