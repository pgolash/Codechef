package LeetCode.Arrays;


import java.util.Iterator;
import java.util.Stack;

class PeekingIterator implements Iterator<Integer> {

    private Stack<Integer> stk;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        stk = new Stack<>();
        Stack<Integer> tmpStk = new Stack<>();

        while (iterator.hasNext()) {
            tmpStk.push(iterator.next());
        }

        while (!tmpStk.isEmpty()) {
            stk.push(tmpStk.pop());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return stk.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return stk.pop();
    }

    @Override
    public boolean hasNext() {
        return !stk.empty();
    }
}