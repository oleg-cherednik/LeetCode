import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 21.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(frequencySort("tree"));      // eert
        System.out.println(frequencySort("cccaaa"));    // cccaaa
        System.out.println(frequencySort("Aabb"));      // bbAa
    }

    public static String frequencySort(String s) {
        class Data implements Comparable<Data> {

            final char ch;
            int count = 1;

            Data(char ch) {
                this.ch = ch;
            }

            @Override
            public int compareTo(Data data) {
                int res = Integer.compare(data.count, count);
                return res == 0 ? Character.compare(ch, data.ch) : res;
            }
        }

        Map<Character, Data> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch))
                map.get(ch).count++;
            else {
                Data data = new Data(ch);
                map.put(ch, data);
            }
        }

        List<Data> values = new ArrayList<>(map.values());
        Collections.sort(values);

        StringBuilder buf = new StringBuilder(s.length());

        for (Data data : values)
            for (int i = 0; i < data.count; i++)
                buf.append(data.ch);

        return buf.toString();
    }

}
