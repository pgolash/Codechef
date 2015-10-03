package LeetCode.Arrays;

import java.util.Stack;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class QueueUsingStacks {
    // Push element x to the back of queue.
    private Stack<Integer> _stack1;
    private Stack<Integer> _stack2;

    QueueUsingStacks() {
        _stack1 = new Stack<>();
        _stack2 = new Stack<>();
    }

    public void push(int x) {
        _stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (_stack2.empty()) {
            while (!_stack1.empty()) {
                _stack2.push(_stack1.pop());
            }
        }

        if (!_stack2.empty()) {
            _stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (_stack2.empty()) {
            while (!_stack1.empty()) {
                _stack2.push(_stack1.pop());
            }
        }

        if (!_stack2.empty()) {
            return _stack2.peek();
        } else {
            return -1;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return _stack1.empty() && _stack2.empty();
    }
}
