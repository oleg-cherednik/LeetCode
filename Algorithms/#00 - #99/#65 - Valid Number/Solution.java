import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * <pre>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * </pre>
 * <ul>
 * <b>Note:</b> It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here
 * is a list of characters that can be in a valid decimal number:
 * <li>Numbers 0-9</li>
 * <li>Exponent - "e"</li>
 * <li>Positive/negative sign - "+"/"-"</li>
 * <li>Decimal point - "."</li>
 * </ul>
 * Of course, the context of these characters also matters in the input.
 * <p>
 * <br>
 * <b>Update (2015-02-10):</b>
 * <p>
 * The signature of the <tt>C++</tt> function had been updated. If you still see your function signature accepts a <tt>const char *</tt> argument,
 * please click the reload button to reset your code definition.
 *
 * @author Oleg Cherednik
 * @since 02.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isNumber("0"));          // true
        System.out.println(isNumber(" 0.1 "));      // true
        System.out.println(isNumber("2e10"));       // true
        System.out.println(isNumber(" -90e3   "));  // true
        System.out.println(isNumber(" 6e-1"));      // true
        System.out.println(isNumber("53.5e93"));    // true
        System.out.println(isNumber(".1"));         // true
        System.out.println(isNumber("-3."));        // true
        System.out.println();
        System.out.println(isNumber("abc"));        // false
        System.out.println(isNumber("1 a"));        // false
        System.out.println(isNumber(" 1e"));        // false
        System.out.println(isNumber("e3"));         // false
        System.out.println(isNumber(" 99e2.5 "));   // false
        System.out.println(isNumber(" --6 "));      // false
        System.out.println(isNumber("-+3"));        // false
        System.out.println(isNumber("95a54e53"));   // false
        System.out.println(isNumber("6e-"));        // false
        System.out.println(isNumber("-90e"));       // false
        System.out.println(isNumber("e9"));         // false
        System.out.println(isNumber(null));         // false
        System.out.println(isNumber(""));           // false
        System.out.println(isNumber("  "));         // false
    }

    public static boolean isNumber(String s) {
        if (s == null)
            return false;

        Pattern pattern = Pattern.compile("(\\+|-)?(([0-9]+(\\.([0-9]+)?)?)|((\\.[0-9]+)))(e(\\+|-)?[0-9]+)?");
        Matcher matcher = pattern.matcher(s.trim());
        return matcher.matches();
    }
}
