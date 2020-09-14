import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following <a href="https://en.wikipedia.org/wiki/Bulls_and_Cows">Bulls and Cows</a> game with your friend: You write down a
 * number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called <b>"bulls"</b>) and how many digits match the secret number but
 * locate in the wrong position (called <b>"cows"</b>). Your friend will use successive guesses and hints to eventually derive the secret number.<br>
 * <br>
 * Write a function to return a hint according to the secret number and friend's guess, use <tt>A</tt> to indicate the <b>bulls</b> and <tt>B</tt> to
 * indicate the <b>cows</b>.<br>
 * <br>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * </pre>
 * <b>Note:</b> You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 * @author Oleg Cherednik
 * @since 10.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getHint("1807", "7810"));    // 1A3B
        System.out.println(getHint("1123", "0111"));    // 1A1B
        System.out.println(getHint("011", "110"));      // 1A2B
        System.out.println(getHint("11", "10"));        // 1A0B
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] arr = new int[10];
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                arr[secret.charAt(i) - '0']++;
                positions.add(i);
            }
        }

        for (int j : positions)
            if (arr[guess.charAt(j) - '0']-- > 0)
                cows++;

        return String.format("%dA%dB", bulls, cows);
    }

}
