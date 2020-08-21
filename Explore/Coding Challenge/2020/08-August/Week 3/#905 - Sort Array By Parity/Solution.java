import java.util.Arrays;

/**
 * Given an array <tt>A</tt> of non-negative integers, return an array consisting of all the even elements of
 * <tt>A</tt>, followed by all the odd elements of <tt>A</tt>.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= A.length <= 5000</tt></li>
 * <li><tt>0 <= A[i] <= 5000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 21.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 3, 1, 2, 4 })));   // [4, 2, 1, 3]
    }

    public static int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; ) {
            if (isEven(A[i]))
                i++;
            else if (!isEven(A[j]))
                j--;
            else
                swap(A, i, j);
        }

        return A;
    }

    private static boolean isEven(int val) {
        return (val & 0x1) == 0;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
