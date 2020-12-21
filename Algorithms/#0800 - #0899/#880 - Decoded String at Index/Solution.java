/**
 * <ul>
 * An encoded string <tt>S</tt> is given. To find and write the <ii>decoded</ii> string to a tape, the encoded string is read <b>one character at a
 * time</b> and the following steps are taken:
 * <p>
 * <li>If the character read is a letter, that letter is written onto the tape.</li>
 * <li>If the character read is a digit (say <tt>d</tt>), the entire current tape is repeatedly written <tt>d-1</tt> more times in total.</li>
 * </ul>
 * Now for some encoded string <tt>S</tt>, and an index <tt>K</tt>, find and return the <tt>K<sub>th</sub></tt> letter (1 indexed) in the decoded string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= S.length <= 100</tt></li>
 * <li><tt>S</tt> will only contain lowercase letters and digits <tt>2</tt> through <tt>9</tt>.</li>
 * <li><tt>S</tt> starts with a letter.</li>
 * <li><tt>1 <= K <= 10<sup>9</sup></tt></li>
 * <li>It's guaranteed that K is less than or equal to the length of the decoded string.</li>
 * <li>The decoded string is guaranteed to have less than 2<sup>63</sup> letters.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 21.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(decodeAtIndex("leet2code3", 10));                // o
        System.out.println(decodeAtIndex("ha22", 5));                       // h
        System.out.println(decodeAtIndex("a2345678999999999999999", 1));    // a
    }

    public static String decodeAtIndex(String S, int K) {
        while (true) {
            long pre = 0;

            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                long len = Character.isDigit(ch) ? pre * (ch - '0') : pre + 1;

                if (len >= K) {
                    if (Character.isLetter(ch))
                        return String.valueOf(ch);
                    break;
                }

                pre = len;
            }

            int mod = (int)(K % pre);
            mod = mod == 0 ? (int)pre : mod;

            K = mod;
        }
    }

}
