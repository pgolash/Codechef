package Design.Practice.Queue;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class Queue<E> implements Serializable {

    private static final int DEFAULT_CAPACITY = 12;
    private Object[] elems = null;
    private int capacity = DEFAULT_CAPACITY;
    private Comparator<E> comp = null;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {


    }

    public Queue(int capacity, Comparator<? extends Comparator<E>> c) {

    }

    // add the element
    public void add(E elem) {


    }

    // returns the top element
    public E remove() {
        return null;
    }

    // peek
    public E peek() {
        return null;
    }



}
