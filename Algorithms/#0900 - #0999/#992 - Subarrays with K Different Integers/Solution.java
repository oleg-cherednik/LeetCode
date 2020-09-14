import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * For a non-negative integer <tt>X</tt>, the <i>array-form</i> of <tt>X</tt> is an array of its digits in left to right order. For example, if <tt>X
 * = 1231</tt>, then the array form is <tt>[1,2,3,1]</tt>.
 * <p>
 * Given the array-form <tt>A</tt> of a non-negative integer <tt>X, return the array-form of the integer <tt>X+K</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * </pre>
 * <b>Note:</b>
 * <ol>
 * <li>1 <= A.length <= 10000</li>
 * <li>0 <= A[i] <= 9</li>
 * <li>0 <= K <= 10000</li>
 * <li>If A.length > 1, then A[0] != 0</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 05.05.2020
 */
public class Solution {

    public static void main(String... args) {
//        System.out.println(subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2)); // 7
//        System.out.println(subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3)); // 3
        System.out.println(subarraysWithKDistinct(new int[] { 1, 2 }, 1));          // 2
    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        Set<Integer> unique = new HashSet<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0, len = 0; i < A.length; i++, len++) {
            unique.add(A[i]);

            if (unique.size() < K)
                continue;

            if(i == A.length - 1) {
                if(unique.size() == K)
                    res += getTotalCombinations(len, K, cache);
            } else {
                if(!unique.contains(A[i + 1])) {
                    res += getTotalCombinations(len, K, cache);

                }


            }



//            if(i < A.length - 1) {
//                if(!unique.contains(A[i + 1]))
//            }



            res += getTotalCombinations(len, K, cache);

            unique.clear();
            unique.add(A[i - 1]);
            unique.add(A[i]);
            len = 2;
        }

        return res;
    }

    private static int getTotalCombinations(int len, int K, Map<Integer, Integer> cache) {
        if (cache.containsKey(len))
            return cache.get(len);

        int res = 0;

        for (int i = K; i <= len; i++)
            res += len - i + 1;

        cache.put(len, res);

        return res;
    }
}
