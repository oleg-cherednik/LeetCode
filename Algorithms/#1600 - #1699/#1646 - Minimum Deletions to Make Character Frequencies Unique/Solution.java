/**
 * A string <tt>s</tt> is called <b>good</b> if there are no two different characters in <tt>s</tt> that have the same
 * <b>frequency.</b>
 * <p>
 * Given a string <tt>s</tt>, return <i>the <b>minimum</b> number of characters you need to delete to make <tt>s</tt>
 * <b>good</b>.</i>
 * <p>
 * The <b>frequency</b> of a character in a string is the number of times it appears in the string. For example, in the
 * string <tt>"aab"</tt>, the <b>frequency</b> of <tt>'a'</tt> is <tt>2</tt>, while the <b>frequency</b> of
 * <tt>'b'</tt> is <tt>1</tt>.
 * <p>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 10<sup>5</sup></tt></li>
 * <li><tt>s</tt> contains only lowercase English letters</li>
 * </il>
 *
 * @author Oleg Cherednik
 * @since 25.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minDeletions("aab"));                // 0
        System.out.println(minDeletions("aaabbbcc"));           // 2
        System.out.println(minDeletions("ceabaacb"));           // 2
        System.out.println(minDeletions("accdcdadddbaadbc"));   // 1
    }

    public static int minDeletions(String s) {
        int[] frequency = calcFrequency(s);
        int res = 0;

        for (int i = 0; i < frequency.length; i++) {
            for (int j = 1; j < frequency[i]; j++) {
                for (int k = i - 1; k >= 0; k--) {
                    res++;

                    if (frequency[k] == 0) {
                        frequency[k]++;
                        break;
                    }
                }
            }
        }

        return res;
    }

    private static int[] calcFrequency(String s) {
        int[] letters = new int[28];
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            letters[j]++;
            maxCount = Math.max(maxCount, letters[j]);
        }

        int[] arr = new int[maxCount + 1];

        for (int i = 0; i < letters.length; i++)
            if (letters[i] > 0)
                arr[letters[i]]++;

        return arr;
    }

}
