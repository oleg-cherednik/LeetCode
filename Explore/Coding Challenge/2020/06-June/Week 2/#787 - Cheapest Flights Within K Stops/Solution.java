import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are <tt>n</tt> cities connected by <tt>m</tt> flights. Each flight starts from city <tt>u</tt> and arrives at <tt>v</tt> with a price
 * <tt>w</tt>.
 * <p>
 * Now given all the cities and flights, together with starting city <tt>src</tt> and the destination <tt>dst</tt>, your task is to find the cheapest
 * price from <tt>src</tt> to <tt>dst</tt> with up to <tt>k</tt> stops. If there is no such route, output <tt>-1</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 * <img src="995.png" />
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 * <img src="995.png" />
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes <tt>n</tt> will be in range <tt>[1, 100]</tt>, with nodes labeled from <tt>0</tt> to <tt>n - 1</tt>.</li>
 * <li>The size of <tt>flights</tt> will be in range <tt>[0, n * (n - 1) / 2]</tt>.</li>
 * <li>The format of each flight will be <tt>(src, dst, price)</tt>.</li>
 * <li>The price of each flight will be in the range <tt>[1, 10000]</tt>.</li>
 * <li><tt>k</tt> is in the range of <tt>[0, n - 1]</tt>.</li>
 * <li>There will not be any duplicated flights or self cycles.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 15.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findCheapestPrice(3, new int[][] {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 0, 2, 500 } }, 0, 2, 1));  // 200
        System.out.println(findCheapestPrice(3, new int[][] {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 0, 2, 500 } }, 0, 2, 0));  // 500
        System.out.println(findCheapestPrice(5, new int[][] {
                { 1, 2, 10 },
                { 2, 0, 7 },
                { 1, 3, 8 },
                { 4, 0, 10 },
                { 3, 4, 2 },
                { 4, 2, 10 },
                { 0, 3, 3 },
                { 3, 1, 6 },
                { 2, 4, 5 }, }, 0, 4, 1));  // 5
        System.out.println(findCheapestPrice(4, new int[][] {
                { 0, 1, 1 },
                { 0, 2, 5 },
                { 1, 2, 1 },
                { 2, 3, 1 } }, 0, 3, 1));  // 6
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n <= 0 || flights == null || flights.length == 0 || K < 0)
            return -1;

        List<List<Pair>> adj = buildGraph(n, flights);
        Queue<City> queue = new PriorityQueue<>(Comparator.comparingInt((City city) -> city.cost));
        queue.add(new City(src, 0, 0));

        while (!queue.isEmpty()) {
            City city = queue.remove();

            if (city.id == dst)
                return city.cost;
            if (city.stops > K)
                continue;

            for (Pair pair : adj.get(city.id))
                queue.offer(new City(pair.cityId, city.stops + 1, city.cost + pair.cost));
        }

        return -1;
    }

    private static List<List<Pair>> buildGraph(int n, int[][] flights) {
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] flight : flights)
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));

        return graph;
    }

    private static final class Pair {

        private final int cityId;
        private final int cost;

        public Pair(int cityId, int cost) {
            this.cityId = cityId;
            this.cost = cost;
        }
    }

    private static final class City {

        private final int id;
        private final int stops;
        private final int cost;

        public City(int id, int stops, int cost) {
            this.id = id;
            this.stops = stops;
            this.cost = cost;
        }
    }

}

