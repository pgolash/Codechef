package LeetCode.Arrays;

import java.util.Stack;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class MinStack {

    private Stack<Integer> original;
    private Stack<Integer> min;

    MinStack() {
        original = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        if (min.empty() || min.peek() >= x) {
            min.push(x);
        }

        original.push(x);
    }

    public void pop() {
        if (!original.empty()) {
            if (original.peek() == min.peek()) {
                min.pop();
            }
            original.pop();
        }
    }

    public int top() {
        return original.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
