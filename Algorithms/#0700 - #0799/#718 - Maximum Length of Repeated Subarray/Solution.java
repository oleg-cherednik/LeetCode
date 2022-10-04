import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Given two integer arrays <tt>nums1</tt> and <tt>nums2</tt>, return the <i>maximum length of a subarray that appears
 * in <b>both</b> arrays</i>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * </pre>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * Explanation:
 * Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums1.length, nums2.length <= 1000</tt></li>
 * <li><tt>0 <= nums1[i], nums2[i] <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 01.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));    // 3
        System.out.println(findLength(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }));    // 3
    }

    public static int findLength(int[] nums1, int[] nums2) {
        Set<Integer> unionNumbers = getUnionNumbers(nums1, nums2);

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.pos));
        queue.addAll(getNumbersPositionsList(nums1, unionNumbers));

        Map<Integer, Set<Integer>> map = getNumbersPositionsMap(nums2, unionNumbers);
        int res = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            for (int pos : map.get(pair.num)) {
                if (pair.pos + res < nums1.length && pos + res < nums2.length) {
                    int length = 0;

                    for (int i = pair.pos, j = pos; i < nums1.length && j < nums2.length; i++, j++) {
                        if (nums1[i] == nums2[j])
                            length++;
                        else
                            break;
                    }

                    res = Math.max(res, length);
                }
            }
        }

        return res;
    }

    private static Set<Integer> getUnionNumbers(int[] nums1, int[] nums2) {
        Set<Integer> unique1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> unique2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        unique1.retainAll(unique2);
        return unique1;
    }

    private static List<Pair> getNumbersPositionsList(int[] arr, Set<Integer> unionNumbers) {
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (unionNumbers.contains(arr[i]))
                pairs.add(new Pair(arr[i], i));
        }

        return pairs;
    }

    private static Map<Integer, Set<Integer>> getNumbersPositionsMap(int[] arr, Set<Integer> unionNumbers) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (unionNumbers.contains(arr[i]))
                map.computeIfAbsent(arr[i], integer -> new TreeSet<>()).add(i);
        }

        return map;
    }

    private static final class Pair {

        final int num;
        final int pos;

        public Pair(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return num + "-" + pos;
        }
    }

}
