/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * @author Oleg Cherednik
 * @since 17.08.2018
 */
public class Solution {

    public int reverse(int x) {
        boolean negative = x < 0;
        String str = String.valueOf(x);
        long res = Long.parseLong(new StringBuilder().append(negative ? str.substring(1) : str).append(negative ? "-" : "").reverse().toString());
        return (int)res != res ? 0 : (int)res;
    }

}
