import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a class <tt>StockSpanner</tt> which collects daily price quotes for some stock, and returns the span of that stock's price for the current
 * day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the
 * price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were <tt>[100, 80, 60, 70, 60, 75, 85]</tt>, then the stock spans would be <tt>[1, 1, 1,
 * 2, 1, 4, 6]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>Calls to <tt>StockSpanner.next(int price)</tt> will have <tt>1 <= price <= 10<sup>5</sup></tt>.</li>
 * <li>There will be at most <tt>10000</tt> calls to <tt>StockSpanner.next</tt> per test case.</li>
 * <li>There will be at most <tt>150000</tt> calls to <tt>StockSpanner.next</tt> across all test cases.</li>
 * <li>The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 19.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(stocksSpanner(100, 80, 60, 70, 60, 75, 85)); // [1, 1, 1, 2, 1, 4, 6]
        System.out.println(stocksSpanner(31, 41, 48, 59, 79));          // [1, 2, 3, 4, 5]
        System.out.println(stocksSpanner(29, 91, 62, 76, 51));          // [1, 2, 1, 2, 1]
    }

    private static List<Integer> stocksSpanner(Integer... prices) {
        StockSpanner obj = new StockSpanner();
        return Arrays.stream(prices).map(obj::next).collect(Collectors.toList());
    }

    private static final class StockSpanner {

        private final List<Integer> prices = new LinkedList<>();
        private final List<Integer> spans = new LinkedList<>();

        public int next(int price) {
            int span = 1;

            for (int i = prices.size() - 1; i >= 0 && price >= prices.get(i); i -= spans.get(i))
                span += spans.get(i);

            spans.add(span);
            prices.add(price);
            return span;
        }
    }

}
