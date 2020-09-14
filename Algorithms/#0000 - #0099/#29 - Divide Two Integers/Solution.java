/**
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    public static void main(String... args) {
//        System.out.println(divide(10, 3));  // 3
//        System.out.println(divide(7, -3));  // -2
//        System.out.println(divide(1, 2));   // 0
        System.out.println(divide(-2147483648, -1));   // 0
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;

        boolean negative = dividend >= 0 ^ divisor >= 0;
        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);

        int res = 0;
        int cur = 0;

        while (cur + divis <= divid) {
            cur += divis;
            res++;
        }

        if (res == 0)
            return 0;
        return negative ? -res : res;
    }

}
