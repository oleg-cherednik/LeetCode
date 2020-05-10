import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A query word matches a given <tt>pattern</tt> if we can insert <b>lowercase</b> letters to the pattern word so that it equals the <tt>query</tt>.
 * (We may insert each character at any position, and may insert 0 characters.)
 * <p>
 * Given a list of <tt>queries</tt>, and a <tt>pattern</tt>, return an <tt>answer</tt> list of booleans, where <tt>answer[i]</tt> is true if and only
 * if <tt>queries[i]</tt> matches the <tt>pattern</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation:
 * "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation:
 * "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation:
 * "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= queries.length <= 100</tt></li>
 * <li><tt>1 <= queries[i].length <= 100</tt></li>
 * <li><tt>1 <= pattern.length <= 100</tt></li>
 * <li>All strings consists only of lower and upper case English letters.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 10.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                "FB"));  // [true, false, true, true, false]
        System.out.println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                "FoBa"));  // [true, false, true, false, false]
        System.out.println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                "FoBaT"));  // [false, true, false, false, false]
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        if (queries == null || queries.length == 0 || pattern == null || pattern.isEmpty())
            return Collections.emptyList();

        List<Boolean> res = new ArrayList<>(queries.length);

        for (String query : queries) {
            boolean valid = true;

            for (int i = 0, j = 0; valid && (i < query.length() || j < pattern.length()); ) {
                if (i >= query.length())
                    valid = false;
                else if (j >= pattern.length()) {
                    if (Character.isLowerCase(query.charAt(i)))
                        i++;
                    else
                        valid = false;
                } else {
                    char actual = query.charAt(i);
                    char expected = pattern.charAt(j);

                    if (actual == expected) {
                        i++;
                        j++;
                    } else if (Character.isUpperCase(expected)) {
                        if (Character.isUpperCase(actual))
                            valid = false;
                        else
                            i++;
                    } else
                        i++;
                }
            }

            res.add(valid);
        }

        return res;
    }

}
