import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string <tt>s</tt>, return <i>the number of segments in the string</i>.
 * <p>
 * A <b>segment</b> is defined to be a contiguous sequence of <b>non-space characters</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "Hello"
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= s.length <= 300</tt></li>
 * <li><tt>s</tt> consists of lowercase and uppercase English letters, digits, or one of the following characters
 * <tt>"!@#$%^&*()_+-=',.:"</tt></li>
 * <li>The only space character in <tt>s</tt> is <tt>' '</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countSegments("Hello, my name is John"));    // 5
        System.out.println(countSegments("Hello"));                     // 1
        System.out.println(countSegments("love live! mu'sic forever")); // 4
        System.out.println(countSegments(""));                          // 0
        System.out.println(countSegments("The one-hour drama series Westworld is a dark odyssey about the dawn of"
                                                 + " artificial consciousness and the evolution of sin. Set at the"
                                                 + " intersection of the near future and the reimagined past, it"
                                                 + " explores a world in which every human appetite, no matter how"
                                                 + " noble or depraved, can be indulged."));  // 50
        System.out.println(countSegments(", , , ,        a, eaefa"));   // 6
        System.out.println(countSegments("    foo    bar"));            // 2
        System.out.println(countSegments("                "));          // 0
    }

    public static int countSegments(String s) {
        int res = 0;
        int curr = 0;
        boolean stopOnSpace = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                if (stopOnSpace) {
                    res++;
                    curr = 0;
                }

                stopOnSpace = false;
            } else
                stopOnSpace = true;

            curr++;
        }

        if (stopOnSpace)
            res++;

        return res;
    }

}
