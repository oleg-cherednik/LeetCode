import java.util.Deque;
import java.util.LinkedList;

/**
 * <ul>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <li><tt>push(x)</tt> -- Push element x onto stack.</li>
 * <li><tt>pop()</tt> -- Removes the element on top of the stack.</li>
 * <li><tt>top()</tt> -- Get the top element.</li>
 * <li><tt>getMin()</tt> -- Retrieve the minimum element in the stack.</li>
 * </ul>
 * <p>
 * <b>Example:</b>
 * <pre>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 10.04.2019
 */
public class Solution {

    public static void main(String... args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // -3
        minStack.pop();
        System.out.println(minStack.top());     // 0
        System.out.println(minStack.getMin());  // -2
    }
}

class MinStack {

    private final Deque<Integer> stack = new LinkedList<>();
    private final Deque<Integer> min = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        min.push(min.isEmpty() ? x : Math.min(min.element(), x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.element();
    }

    public int getMin() {
        return min.element();
    }
}
