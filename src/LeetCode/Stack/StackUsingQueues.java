package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class StackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = q2;


        q1.add(x);

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        q2 = q1;
        q1 = temp;

    }

    // Removes the element on top of the stack.
    public void pop() {
        q2.remove();
    }

    // Get the top element.
    public int top() {
        return q2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stk = new StackUsingQueues();
        stk.push(12);
        stk.push(11);
        stk.push(10);
        System.out.println(stk.top());
        stk.pop();
        stk.pop();
        System.out.println(stk.top());
    }
}

