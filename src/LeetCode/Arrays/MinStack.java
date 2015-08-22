package LeetCode.Arrays;

import java.util.Stack;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class MinStack {

    private Stack<Integer> original;
    private Stack<Integer> min;

    MinStack() {
        original = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (min.empty() || min.peek() >= x) {
            min.push(x);
        }

        original.push(x);
    }

    public void pop() {
        if (!original.empty()) {
            if (original.peek().intValue() == min.peek().intValue()) {
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

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);

        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
