import java.util.Arrays;

/**
 * Given a non negative integer number <tt>num</tt>. For every numbers <t>>i</t> in the range <tt>0 ≤ i ≤ num</tt> calculate the number of 1's in
 * their binary representation and return them as an array.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2
 * Output: [0,1,1]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * </pre>
 * <ul>
 * <b>Follow up:</b>
 * <li>It is very easy to come up with a solution with run time <tt>O(n*sizeof(integer))</tt>. But can you do it in linear time <tt>O(n)</tt> /possibly in a single pass?</li>
 * <li>Space complexity should be <tt>O(n)</tt>.</li>
 * <li>Can you do it like a boss? Do it without using any builtin function like <b>__builtin_popcount</b> in c++ or in any other language.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 28.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(countBits(2)));  // [0, 1, 1]
        System.out.println(Arrays.toString(countBits(5)));  // [0, 1, 1, 2, 1, 2]
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++)
            res[i] = getSetBitAmount(i);

        return res;
    }

    private static final int G31 = 0b0100_1001_0010_0100_1001_0010_0100_1001;
    private static final int G32 = 0b0011_1000_0001_1100_0000_1110_0000_0111;

    private static int getSetBitAmount(int val) {
        val = (val & G31) + ((val >> 1) & G31) + ((val >> 2) & G31);
        val = ((val + (val >> 3)) & G32) + ((val >> 6) & G32);
        return (val + (val >> 9) + (val >> 18) + (val >> 27)) & 0x3f;
    }
}
