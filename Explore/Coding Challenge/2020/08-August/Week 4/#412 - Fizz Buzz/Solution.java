import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from <tt>1</tt> to <tt>n</tt>.
 * <p>
 * But for multiples of three it should output <tt>“Fizz”</tt> instead of the number and for the multiples of five output <tt>“Buzz”</tt>. For numbers
 * which are multiples of both three and five output <tt>“FizzBuzz”</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fizzBuzz(15));   // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FixxBuzz]
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            boolean mulThree = i % 3 == 0;
            boolean mulFive = i % 5 == 0;

            if (mulThree && mulFive)
                res.add("FizzBuzz");
            else if (mulThree)
                res.add("Fizz");
            else if (mulFive)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }

        return res;
    }

}
