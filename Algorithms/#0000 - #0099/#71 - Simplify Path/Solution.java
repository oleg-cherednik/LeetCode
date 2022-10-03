import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string <tt>path</tt>, which is an <b>absolute path</b> (starting with a slash <tt>'/'</tt>) to a file or
 * directory in a Unix-style file system, convert it to the simplified <b>canonical path</b>.
 * <p>
 * In a Unix-style file system, a period <tt>'.'</tt> refers to the current directory, a double period <tt>'..'</tt>
 * refers to the directory up a level, and any multiple consecutive slashes (i.e. <tt>'//'</tt>) are treated as a single
 * slash <tt>'/'</tt>. For this problem, any other format of periods such as <tt>'...'</tt> are treated as file/directory
 * names.
 * <ul>
 * The <b>canonical path</b> should have the following format:
 * <li>The path starts with a single slash <tt>'/'</tt>.</li>
 * <li>Any two directories are separated by a single slash <tt>'/'</tt>.</li>
 * <li>The path does not end with a trailing <tt>'/'</tt>.</li>
 * <li>The path only contains the directories on the path from the root directory to the target file or directory
 * (i.e., no period <tt>'.'</tt> or double period <tt>'..'</tt>)</li>
 * </ul>
 * Return <i>the simplified <b>canonical path</b></i>.
 * <b>Example 1:</b>
 * <pre>
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= path.length <= 3000</tt></li>
 * <li><tt>path</tt> consists of English letters, digits, period <tt>'.'</tt>, slash <tt>'/'</tt> or <tt>'_'</tt>.</li>
 * <li><tt>path</tt> is a valid absolute Unix path.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(simplifyPath("/home/")); // /home
        System.out.println(simplifyPath("//..//")); // /
        System.out.println(simplifyPath("/home//foo/")); // /home/foo
        System.out.println(simplifyPath("/...")); // /...
        System.out.println(simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
    }

    public static String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        StringBuilder buf = null;

        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            boolean lastSymbol = i + 1 == path.length();

            if (ch != '/' && lastSymbol)
                buf = add(buf, ch);

            if (ch == '/' || lastSymbol) {
                String part = buf == null ? null : buf.toString();

                if ("..".equals(part)) {
                    if (!queue.isEmpty())
                        queue.removeLast();
                } else if (!".".equals(part)) {
                    if (buf != null)
                        queue.add(buf.toString());
                }

                buf = null;
            } else
                buf = add(buf, ch);
        }

        if (queue.isEmpty())
            return "/";

        buf = new StringBuilder();

        for (String part : queue)
            buf.append('/').append(part);

        return buf.toString();
    }

    private static StringBuilder add(StringBuilder buf, char ch) {
        buf = buf == null ? new StringBuilder() : buf;
        return buf.append(ch);
    }
}
