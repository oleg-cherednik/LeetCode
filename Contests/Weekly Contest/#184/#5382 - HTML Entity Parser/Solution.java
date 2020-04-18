/**
 * <b>HTML entity parser</b> is the parser that takes HTML code as input and replace all the entities of the special characters by the characters
 * itself.
 * <ul>
 * The special characters and their entities for HTML are:
 * <li><b>Quotation Mark:</b> the entity is <tt>{@literal &quot;}</tt> and symbol character is <tt>"</tt>.</li>
 * <li><b>Single Quote Mark:</b> the entity is <tt>{@literal &apos;}</tt> and symbol character is <tt>'</tt>.</li>
 * <li><b>Ampersand:</b> the entity is <tt>{@literal &amp;}</tt> and symbol character is <tt>&</tt>.</li>
 * <li><b>Greater Than Sign:</b> the entity is <tt>{@literal &gt;}</tt> and symbol character is <tt>&gt;</tt>.</li>
 * <li><b>Less Than Sign:</b> the entity is <tt>{@literal &lt;}</tt> and symbol character is <tt>&lt;</tt>.</li>
 * <li><b>Slash:</b> the entity is <tt>{@literal &frasl;}</tt> and symbol character is <tt>/</tt>.</li>
 * </ul>
 * Given the input <tt>text</tt> string to the HTML parser, you have to implement the entity parser.
 * <p>
 * Return <i>the text</i> after replacing the entities by the special characters.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: text = "&amp; is an HTML entity but &ambassador; is not."
 * Output: "& is an HTML entity but &ambassador; is not."
 * Explanation: The parser will replace the &amp; entity by &
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: text = "and I quote: &quot;...&quot;"
 * Output: "and I quote: \"...\""
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: text = "Stay home! Practice on Leetcode :)"
 * Output: "Stay home! Practice on Leetcode :)"
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * Output: "x > y && x < y is always false"
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: text = "leetcode.com&frasl;problemset&frasl;all"
 * Output: "leetcode.com/problemset/all"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= text.length <= 10<sup>5</sup></tt></li>
 * <li>The string may contain any possible characters out of all the 256 ASCII characters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));   // & is an HTML entity but &ambassador; is not.
        System.out.println(entityParser("and I quote: &quot;...&quot;"));                       // and I quote: \"...\"
        System.out.println(entityParser("Stay home! Practice on Leetcode :)"));                 // Stay home! Practice on Leetcode :)
        System.out.println(entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));       // x > y && x < y is always false
        System.out.println(entityParser("leetcode.com&frasl;problemset&frasl;all"));            // leetcode.com/problemset/all
        System.out.println(entityParser("and I quote: &quot;...&quot;"));                       // and I quote: \"...\"
        System.out.println(entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));       // x > y && x < y is always false
    }

    public static String entityParser(String text) {
        StringBuilder buf = new StringBuilder(text.length());
        int i = 0;

        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                String str = text.substring(i, i + 4);

                if ("&lt;".equals(str)) {
                    buf.append('<');
                    i += 4;
                    continue;
                }

                if ("&gt;".equals(str)) {
                    buf.append('>');
                    i += 4;
                    continue;
                }

                str = text.substring(i, i + 5);

                if ("&amp;".equals(str)) {
                    buf.append('&');
                    i += 5;
                    continue;
                }

                str = text.substring(i, i + 6);

                if ("&quot;".equals(str)) {
                    buf.append('"');
                    i += 6;
                    continue;
                }

                if ("&apos;".equals(str)) {
                    buf.append('\'');
                    i += 6;
                    continue;
                }

                str = text.substring(i, i + 7);

                if ("&frasl;".equals(str)) {
                    buf.append('/');
                    i += 7;
                    continue;
                }
            }

            buf.append(text.charAt(i++));
        }

        return buf.toString();
    }
}
