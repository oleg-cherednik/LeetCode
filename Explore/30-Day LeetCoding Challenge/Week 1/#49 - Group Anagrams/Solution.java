import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>All inputs will be in lowercase.</li>
 * <li>The order of your output does not matter.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 06.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(groupAnagramsAndPrint("eat", "tea", "tan", "ate", "nat", "bat"));    // [["ate","eat","tea"],["nat","tan"],["bat"]]
    }

    public static String groupAnagramsAndPrint(String... strs) {
        List<List<String>> groups = groupAnagrams(strs);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (List<String> group : groups) {
            if (buf.length() > 1)
                buf.append(", ");
            buf.append(Arrays.toString(group.toArray()));
        }

        buf.append(']');

        return buf.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            map.compute(new String(arr), (key, values) -> {
                (values = Optional.ofNullable(values).orElseGet(ArrayList::new)).add(str);
                return values;
            });
        }

        return new ArrayList<>(map.values());
    }
}
