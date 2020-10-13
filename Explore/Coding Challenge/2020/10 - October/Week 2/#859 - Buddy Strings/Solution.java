/**
 * Given two strings <tt>A</tt> and <tt>B</tt> of lowercase letters, return <i><tt>true</tt> if you can swap two letters in <tt>A</tt> so the result
 * is equal to <tt>B</tt>, otherwise, return false</i>.
 * <p>
 * Swapping letters is defined as taking two indices <tt>i</tt> and <tt>j</tt> (0-indexed) such that <tt>i != j</tt> and swapping the characters at
 * <tt>A[i]</tt> and <tt>A[j]</tt>. For example, swapping at indices <tt>0</tt> and <tt>2</tt> in <tt>"abcd"</tt> results in <tt>"cbad"</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: A = "", B = "aa"
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= A.length <= 20000</tt></li>
 * <li><tt>0 <= B.length <= 20000</tt></li>
 * <li><tt>A</tt> and <tt>B</tt> consist of lowercase letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(buddyStrings("ab", "ba"));               // true
        System.out.println(buddyStrings("ab", "ab"));               // false
        System.out.println(buddyStrings("aa", "aa"));               // true
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(buddyStrings("", "aa"));                 // false
        System.out.println(buddyStrings("abcd", "cbad"));           // true
        System.out.println(buddyStrings("abcd", "abcd"));           // false
        System.out.println(buddyStrings("abab", "abab"));           // true
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() < 2)
            return false;

        if (A.equals(B)) {
            if (A.length() > 26)
                return true;

            int[] letters = new int[26];

            for (int i = 0; i < A.length(); i++)
                if (++letters[A.charAt(i) - 'a'] > 1)
                    return true;

            return false;
        }

        int j = -1;
        int k = -1;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i))
                continue;
            if (j == -1)
                j = i;
            else if (k == -1)
                k = i;
            else
                return false;
        }

        return k != -1 && A.charAt(j) == B.charAt(k) && A.charAt(k) == B.charAt(j);
    }

}
