import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as <tt>'A'</tt>, <tt>'C'</tt>, <tt>'G'</tt>, and <tt>'T'</tt>, for example:
 * <tt>"ACGAATTCCG"</tt>. When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= s.length <= 10<sup>5</sup></tt></li>
 * <li><tt>s[i]</tt> is <tt>'A'</tt>, <tt>'C'</tt>, <tt>'G'</tt>, or <tt>'T'</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findRepeatedDnaSequencesStr("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));   // [AAAAACCCCC, CCCCCAAAAA]
        System.out.println(Arrays.toString(findRepeatedDnaSequencesStr("AAAAAAAAAAAAA")));                      // [AAAAAAAAAA]
    }

    public static String[] findRepeatedDnaSequencesStr(String s) {
        List<String> res = findRepeatedDnaSequences(s);
        return res.stream().toArray(String[]::new);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String key = s.substring(i, i + 10);
            Integer count = map.getOrDefault(key, 0);
            map.put(key, count + 1);

            if (count == 1)
                res.add(key);
        }

        return res;
    }

}
