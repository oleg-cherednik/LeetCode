/**
 * Given a string <b>s</b>, find the longest palindromic substring in <b>s</b>. You may assume that the maximum length of <b>s</b> is 1000.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "cbbd"
 * Output: "bb"
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 19.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd"));  // bb
    }

    public static String longestPalindrome(String s) {
        String palindrome = "";

        for (int i = 0; i < s.length() - palindrome.length(); i++) {
            for (int j = s.length(); j >= i && j - i > palindrome.length(); j--) {
                if (isPalindrome(s, i, j - 1)) {
                    palindrome = s.substring(i, j);
                    break;
                }
            }
        }

        return palindrome;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

}
