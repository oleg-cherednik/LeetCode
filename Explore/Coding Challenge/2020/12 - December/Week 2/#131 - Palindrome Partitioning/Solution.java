import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string <tt>s</tt>, partition <tt>s</tt> such that every substring of the partition is a <b>palindrome</b>. Return all possible palindrome
 * partitioning of <tt>s</tt>.
 * <p>
 * A <b>palindrome</b> string is a string that reads the same backward as forward.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "a"
 * Output: [["a"]]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 16</tt></li>
 * <li><tt>s</tt> contains only lowercase English letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 15.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(partitionStr("aab"));    // [[a,a,b], [aa,b]]
        System.out.println(partitionStr("a"));      // [[a]]
    }

    private static List<String> partitionStr(String s) {
        return partition(s).stream()
                           .map(items -> items.stream().collect(Collectors.joining(",", "[", "]")))
                           .collect(Collectors.toList());
    }

    public static List<List<String>> partition(String s) {
        if (s == null || s.isEmpty())
            return Collections.emptyList();
        if (s.length() == 1)
            return Collections.singletonList(Collections.singletonList(s));

        List<List<String>> res = new LinkedList<>();

        if (isPalindrome(s))
            res.add(Collections.singletonList(s));

        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0, i);

            if (isPalindrome(str))
                for (List<String> partitions : partition(s.substring(i)))
                    res.add(Stream.concat(Stream.of(str), partitions.stream()).collect(Collectors.toList()));
        }

        return res;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

}
