/**
 * @author Oleg Cherednik
 * @since 07.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));    // 4
        System.out.println(numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 0));    // 2
        System.out.println(numSubarraysWithSum(new int[] { 0, 0, 0, 0, 0 }, 0));    // 15
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0)
            return 0;

        int res = 0;

        for (int len = 1; len <= A.length; len++) {
            int sum = 0;
            int i = 0;
            int j = 0;

            for (; j < len; j++)
                sum += A[j];

            j--;

            while (j < A.length) {
                if (sum == S)
                    res++;

                if (j + 1 == A.length)
                    break;

                sum += A[++j];
                sum -= A[i++];
            }
        }

        return res;
    }

}
