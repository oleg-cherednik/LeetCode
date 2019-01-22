/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * </pre>
 * <p>
 * <b>Note:</b><br>
 * All given inputs are in lowercase letters a-z.
 *
 * @author Oleg Cherednik
 * @since 22.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestCommonPrefix(new String[] { "ca", "a" }));
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog", "rececar", "car" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String res = strs[0];

        for (int i = 0; i < strs.length; i++)
            if (strs[i].length() < res.length())
                res = strs[i];

        for (int i = 0, j = 0; !res.isEmpty() && i < strs.length; i++, j = 0) {
            for (; j < res.length(); j++)
                if (res.charAt(j) != strs[i].charAt(j))
                    break;

            res = res.substring(0, j);
        }

        return res;
    }

}
