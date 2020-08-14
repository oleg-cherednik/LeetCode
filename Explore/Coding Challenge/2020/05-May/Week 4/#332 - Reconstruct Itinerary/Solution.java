import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports <tt>[from, to]</tt>, reconstruct the itinerary in order. All
 * of the tickets belong to a man who departs from <tt>JFK</tt>. Thus, the itinerary must begin with <tt>JFK</tt>.
 * <ol>
 * <b>Note:</b>
 * <li>If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For
 * example, the itinerary <tt>["JFK", "LGA"]</tt> has a smaller lexical order than <tt>["JFK", "LGB"]</tt>.</li>
 * <li>All airports are represented by three capital letters (IATA code).</li>
 * <li>You may assume all tickets form at least one valid itinerary.</li>
 * <li>One must use all the tickets once and only once.</li>
 * </ol>
 * <b>Example 1:</b>
 * <pre>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 29.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")))); // [JFK, MUC, LHR, SFO, SJC]

        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")))); // [JFK, ATL, JFK, SFO, ATL, SFO]

        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("EZE", "AXA"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("ANU", "JFK"),
                Arrays.asList("JFK", "ANU"),
                Arrays.asList("ANU", "EZE"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("AXA", "TIA"),
                Arrays.asList("TIA", "JFK"),
                Arrays.asList("ANU", "TIA"),
                Arrays.asList("JFK", "TIA")))); // [JFK, ANU, EZE, AXA, TIA, ANU, JFK, TIA, ANU, TIA, JFK]
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (List<String> ticket : tickets)
            map.computeIfAbsent(ticket.get(0), t -> new PriorityQueue<>()).add(ticket.get(1));

        Deque<String> stack = new LinkedList<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String from = stack.peek();

            if (map.containsKey(from) && !map.get(from).isEmpty())
                stack.push(map.get(from).poll());
            else
                res.add(0, stack.pop());
        }

        return res;
    }

}
