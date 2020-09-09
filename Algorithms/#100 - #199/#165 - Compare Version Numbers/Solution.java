/**
 * Compare two version numbers <tt>version1</tt> and <tt>version2</tt>.
 * If <tt>version1 > version2</tt> return <tt>1</tt>; if <tt>version1 < version2</tt> return <tt>-1</tt>; otherwise return <tt>0</tt>.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the <tt>.</tt> character.
 * <p>
 * The <tt>.</tt> character does not represent a decimal point and is used to separate number sequences.
 * <p>
 * For instance, <tt>2.5</tt> is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level
 * revision.
 * <p>
 * You may assume the default revision number for each level of a version number to be <tt>0</tt>. For example, version number <tt>3.4</tt> has a
 * revision number of <tt>3</tt> and <tt>4</tt> for its first and second level revision number. Its third and fourth level revision number are both
 * <tt>0</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>Version strings are composed of numeric strings separated by dots <tt>.</tt> and this numeric strings <b>may</b> have leading zeroes.</li>
 * <li>Version strings do not start or end with dots, and they will not be two consecutive dots.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 09.09.2020
 */

public class Solution {

    public static void main(String... args) {
        System.out.println(compareVersion("0.1", "1.1"));       // -1
        System.out.println(compareVersion("1.0.1", "1"));       // 1
        System.out.println(compareVersion("7.5.2.4", "7.5.3")); // -1
        System.out.println(compareVersion("1.01", "1.001"));    // 0
        System.out.println(compareVersion("1.0", "1.0.0"));     // 0
    }

    public static int compareVersion(String version1, String version2) {
        int from1 = 0;
        int from2 = 0;

        do {
            int to1 = from1 == -1 ? -1 : version1.indexOf('.', from1 + 1);
            int to2 = from2 == -1 ? -1 : version2.indexOf('.', from2 + 1);

            int val1 = from1 == -1 ? 0 : Integer.parseInt(version1.substring(from1, to1 == -1 ? version1.length() : to1));
            int val2 = from2 == -1 ? 0 : Integer.parseInt(version2.substring(from2, to2 == -1 ? version2.length() : to2));

            from1 = to1 == -1 ? -1 : to1 + 1;
            from2 = to2 == -1 ? -1 : to2 + 1;

            int res = Integer.compare(val1, val2);

            if (res != 0)
                return res;
        } while (from1 != -1 || from2 != -1);

        return 0;
    }
}
