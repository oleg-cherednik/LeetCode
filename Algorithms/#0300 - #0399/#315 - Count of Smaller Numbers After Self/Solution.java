import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array <i>nums</i> and you have to return a new <i>counts</i> array. The <i>counts</i> array has the property where
 * <tt>counts[i]</tt> is the number of smaller elements to the right of <tt>nums[i]</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.05.2019
 */
public class Solution {

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        class Node {

        }


        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> res = new ArrayList<>(nums.length);

        for(int i = nums.length - 1; i >= 0; i--) {
            bst.
            bst.
        }

        return res;
    }

}
