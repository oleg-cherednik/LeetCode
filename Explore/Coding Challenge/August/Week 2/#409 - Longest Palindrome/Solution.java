/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example <tt>"Aa"</tt> is not considered a palindrome here.
 * <p>
 * <b>Note:</b>
 * <p>
 * Assume the length of given string will not exceed <tt>1,010</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestPalindrome("abccccdd"));  // 7
        System.out.println(longestPalindrome("bananas"));   // 5
        System.out.println(longestPalindrome("bananas"));   // 5
    }

    public static int longestPalindrome(String s) {
        int[] arr = new int[Math.max('Z', 'z') + 1];
        int res = 0;

        for (int i = 0; i < s.length(); i++)
            if (++arr[s.charAt(i)] % 2 == 0)
                res += 2;

        for (int a : arr)
            if (a % 2 != 0)
                return res + 1;

        return res;
    }

}
