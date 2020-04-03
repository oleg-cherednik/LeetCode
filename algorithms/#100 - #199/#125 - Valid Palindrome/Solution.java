/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * <b>Note:</b> For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "race a car"
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        for (int i = 0, j = s.length() - 1; i < j; ) {
            char one = Character.toLowerCase(s.charAt(i));
            char two = Character.toLowerCase(s.charAt(j));

            if (!Character.isLetterOrDigit(one))
                i++;
            else if (!Character.isLetterOrDigit(two))
                j--;
            else if (one == two) {
                i++;
                j--;
            } else
                return false;
        }

        return true;
    }

}
