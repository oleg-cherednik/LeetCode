/**
 * @author Oleg Cherednik
 * @since 15.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));  // 1
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));            // 2
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } }));                      // 0
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        return 0;
    }

}
