/**
 * Given a <tt>word</tt>, you need to judge whether the usage of capitals in it is right or not.
 * <ol>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <li>All letters in this word are capitals, like <b>"USA"</b>.</li>
 * <li>All letters in this word are not capitals, like <b>"leetcode"</b>.</li>
 * <li>Only the first letter in this word is capital, like <b>"Google"</b>.</li>
 * </ol>
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "USA"
 * Output: True
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "FlaG"
 * Output: False
 * </pre>
 * <b>Note:</b> The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 * @author Oleg Cherednik
 * @since 01.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(detectCapitalUse("USA"));        // true
        System.out.println(detectCapitalUse("Google"));     // true
        System.out.println(detectCapitalUse("leetcode"));   // true
        System.out.println(detectCapitalUse("FlaG"));       // false
    }

    public static boolean detectCapitalUse(String word) {
        boolean upperCaseExpected = false;

        for (int i = 0; i < word.length(); i++) {
            boolean upperCase = Character.isUpperCase(word.charAt(i));

            if (i == 0)
                upperCaseExpected = upperCase;
            else if (i == 1) {
                if (upperCase) {
                    if (!upperCaseExpected)
                        return false;
                } else
                    upperCaseExpected = false;
            } else if (upperCaseExpected != upperCase)
                return false;
        }

        return true;
    }
}
