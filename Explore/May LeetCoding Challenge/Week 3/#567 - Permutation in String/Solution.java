/**
 * Given two strings <tt>s1</tt> and <tt>s2</tt>, write a function to return true if <tt>s2</tt> contains the permutation of <tt>s1</tt>. In other
 * words, one of the first string's permutations is the <b>substring</b> of the second string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The input strings only contain lower case letters.</li>
 * <li>The length of both given strings is in range <tt>[1, 10,000]</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 18.0452020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));   // true
        System.out.println(checkInclusion("ab", "eidboaoo"));   // false
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] expected = histogram(s1);
        int[] actual = new int[26];

        for (int i = 0, j = 0; j < s2.length(); j++) {
            int length = j - i + 1;
            actual[s2.charAt(j) - 'a']++;


            if (length < s1.length())
                continue;

            if (isEquals(expected, actual))
                return true;

            actual[s2.charAt(i++) - 'a']--;
        }

        return false;
    }

    private static boolean isEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++)
            if (expected[i] != actual[i])
                return false;

        return true;
    }

    private static int[] histogram(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 'a']++;

        return arr;
    }

}
