/**
 * Write a function that reverses a string. The input string is given as an array of characters <tt>char[]</tt>.
 * <p>
 * Do not allocate extra space for another array, you must do this by <b>modifying the input array in-place</b> with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        reverseString("hello"); // olleh
        reverseString("Hannah"); // hannaH
    }

    public static void reverseString(String str) {
        char[] arr = str.toCharArray();
        reverseString(arr);
        System.out.println(new String(arr));
    }

    public static void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    private static void reverseString(char[] s, int i, int j) {
        if (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            reverseString(s, i + 1, j - 1);
        }
    }
}
