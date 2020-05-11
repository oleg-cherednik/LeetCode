import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers and an integer <tt>target</tt>, are there elements <tt>a</tt>, <tt>b</tt>, <tt>c</tt>, and
 * <tt>d</tt> in
 * <tt>nums</tt> such that <tt>a + b + c + d = target</tt>? Find all unique quadruplets in the array which gives the sum of <tt>target</tt>.
 * <p>
 * <b>Note:</b>
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fourSumToString(new int[] { 1, 0, -1, 0, -2, 2 }, 0));   // [[1, 0, -1, 0], [1, -1, -2, 2], [0, 0, -2, 2]]
        System.out.println(fourSumToString(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 },
                0));   // [[-2, -1, 0, 3], [-2, 0, 0, 2], [-3, -1, 1, 3], [-3, 0, 1, 2], [-3, 0, 0, 3], [-2, -1, 1, 2], [-1, 0, 0, 1], [-3, -2, 2, 3]]
        System.out.println(fourSumToString(new int[] { -5, 5, 4, -3, 0, 0, 4, -2 }, 4));   // [[-5, 0, 4, 5], [-3, -2, 4, 5]]
    }

    private static List<String> fourSumToString(int[] nums, int target) {
        List<List<Integer>> res = fourSum(nums, target);
        return res.stream().map(sum -> sum.stream().mapToInt(i -> i).toArray()).map(Arrays::toString).collect(Collectors.toList());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        class Data {

            final int a;
            final int b;
            final int c;
            final int d;

            public Data(int a, int b, int c, int d) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d = d;
            }

            public List<Integer> list() {
                return Arrays.asList(a, b, c, d);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (!(obj instanceof Data))
                    return false;
                return a == ((Data)obj).a && b == ((Data)obj).b && c == ((Data)obj).c && d == ((Data)obj).d;
            }

            @Override
            public int hashCode() {
                return Objects.hash(a, b, c, d);
            }
        }

        Arrays.sort(nums);
        Set<Data> unique = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 3; i++)
            for (int j = i + 1; j < nums.length - 2; j++)
                for (int k = j + 1; k < nums.length - 1; k++)
                    for (int l = k + 1; l < nums.length; l++)
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target)
                            unique.add(new Data(nums[i], nums[j], nums[k], nums[l]));

        return unique.stream().map(Data::list).collect(Collectors.toList());
    }
}
