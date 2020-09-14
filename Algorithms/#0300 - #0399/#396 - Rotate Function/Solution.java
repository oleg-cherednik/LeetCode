import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * <b>Example:</b>
 * <pre>
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * </pre>
 * <p>
 * <b>Node:</b> You may assume the string contain only lowercase letters.<br>
 *
 * @author Oleg Cherednik
 * @since 21.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxRotateFunction(new int[] { 4, 3, 2, 6 }));    // 26
        System.out.println(maxRotateFunction(new int[] { -2147483648, -2147483648 }));    // -2147483648
    }

    public static int maxRotateFunction(int[] A) {
        if (A.length == 0)
            return 0;

        int res = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        String str = Arrays.stream(A).mapToObj(String::valueOf).collect(Collectors.joining());

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(str)) {
                int sum = 0;

                for (int j = 0, k = i; j < A.length; j++, k = ++k == A.length ? 0 : k)
                    sum += j * A[k];

                map.put(str, sum);
            }

            res = Math.max(res, map.get(str));
            str = str.substring(1) + str.charAt(0);
        }

        return res;
    }

}
