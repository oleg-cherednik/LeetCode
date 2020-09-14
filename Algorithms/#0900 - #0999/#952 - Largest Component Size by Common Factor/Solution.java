import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 31.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestComponentSize(new int[] { 2, 3, 6, 7, 4, 12, 21, 39 })); // [1, 1, 1, 2, 1, 4, 6]
    }

    public static int largestComponentSize(int[] A) {
        Map<Integer, Set<Integer>> values = new HashMap<>();

        for (int a : A) {
            for (int i = 2; i <= a; i++) {
                if (a % i != 0)
                    continue;

                if (!values.containsKey(i))
                    values.put(i, new HashSet<>());
                values.get(i).add(a);

                if (a / i <= 1)
                    continue;

                if (!values.containsKey(a / i))
                    values.put(a / i, new HashSet<>());
                values.get(a / i).add(a);
            }
        }

        return 1;

    }

}
