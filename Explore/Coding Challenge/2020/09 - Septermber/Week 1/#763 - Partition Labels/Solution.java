import java.util.ArrayList;
import java.util.List;

/**
 * A string <tt>S</tt> of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter
 * appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>S</tt> will have length in range <tt>[1, 500]</tt>.</li>
 * <li><tt>S</tt> will consist of lowercase English letters (<tt>'a'</tt> to <tt>'z'</tt>) only.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));    // [9, 7, 8]
    }

    public static List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];

        for (int i = 0; i < S.length(); i++)
            arr[S.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();

        for (int i = 0, min = -1, max = -1; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (min == -1) {
                min = i;
                max = arr[ch - 'a'];
            }

            if (i == max || i + 1 == S.length()) {
                res.add(max - min + 1);
                min = -1;
            } else
                max = Math.max(max, arr[ch - 'a']);
        }

        return res;
    }

}
