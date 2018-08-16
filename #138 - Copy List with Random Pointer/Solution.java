import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * @author Oleg Cherednik
 * @since 16.08.2018
 */
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        final Function<RandomListNode, String> getKey = node -> node != null ? node.toString() : null;
        Map<String, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;
        RandomListNode prv = null;

        while (node != null) {
            String key = getKey.apply(node);
            RandomListNode nodeCopy = map.get(key);

            if (nodeCopy == null)
                map.put(key, nodeCopy = new RandomListNode(node.label));

            if (node.random != null) {
                String keyRandom = getKey.apply(node.random);
                nodeCopy.random = map.get(keyRandom);

                if (nodeCopy.random == null)
                    map.put(keyRandom, nodeCopy.random = new RandomListNode(node.random.label));
            }

            if (prv == null)
                prv = nodeCopy;
            else {
                prv.next = nodeCopy;

                if (prv.next.next != null)
                    break;

                prv = prv.next;
            }

            node = node.next;
        }

        return map.get(getKey.apply(head));
    }
}

class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
