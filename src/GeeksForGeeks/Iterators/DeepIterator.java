package GeeksForGeeks.Iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
* Created by prashantgolash on 30/12/15.
*/
interface Data<T> {
// Does this Data hold a collection?
public boolean isCollection();
// Returns the collection contained by
// this Data, or null if it is a single element
public Collection<Data<T>> getCollection();
// Returns the single element contained
//by this Data, or null if it is  collection
public T getElement();
}

public class DeepIterator implements Iterator<Data> {
    private Stack<Iterator<Data>> stack = new Stack<>();
    private Data top = null;

    public DeepIterator(List<Data> input) {
        stack.push(input.iterator());
    }

    @Override
    public boolean hasNext() {
        if (this.top != null) {
            return true;
        }

        while (!stack.isEmpty()) {
            Iterator<Data> it = stack.peek();

            if (it.hasNext()) {
                Data curr = it.next();
                if (!curr.isCollection()) {
                    top = (Data)curr.getElement();
                    return true;
                } else {
                    stack.push(curr.getCollection().iterator());
                }
            } else {
                stack.pop();
            }
        }

        return false;
    }

    @Override
    public Data next() {
        if (top != null) {
            Integer result = (Integer) top.getElement();
            top = null;
            return top;
        } else {
            return null;
        }
    }
}
