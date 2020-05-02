import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings <tt>J</tt> representing the types of stones that are jewels, and <tt>S</tt> representing the stones you have. Each character
 * in <tt>S</tt> is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in <tt>J</tt> are guaranteed distinct, and all characters in <tt>J</tt> and <tt>S</tt> are letters. Letters are case sensitive, so
 * <tt>"a"</tt> is considered a different type of stone from <tt>"A"</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>S</tt> and <tt>J</tt> will consist of letters and have length at most 50.</li>
 * <li>The characters in <tt>J</tt> are distinct.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(numJewelsInStones("z", "ZZ"));       // 0
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();

        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));

        int res = 0;

        for (int i = 0; i < S.length(); i++)
            if (jewels.contains(S.charAt(i)))
                res++;

        return res;
    }

}

