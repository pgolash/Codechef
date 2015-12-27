package GeeksForGeeks.Arrays;

import java.util.Comparator;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class BinaryHeap<T> {

    private Object[] elems = null;
    private Integer defaultCapacity = 10;
    private Comparator<T> defaultComparator = null;
    private Integer size = 0;

    public BinaryHeap() {
        elems = new Object[defaultCapacity];
        defaultComparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return 0;
            }
        };
    }

    public BinaryHeap(Comparator<T> c) {
        defaultComparator = c;
    }

    // additional method supported by our binary heap
    public boolean remove(int idx) {
        return true;
    }

    // return index of the array element
    public int add(T elem) {
        if (full()) {
            grow();
        }

        elems[size++] = elem;
        return heapify(size);
    }

    public int heapify(int size) {
        int parentIdx = size / 2;

        if (size % 2 == 0) {
            // right child is not there

        } else {

        }

        return -1;
    }

    public boolean full() {
        return true;
    }

    public void grow() {
        return;
    }
}
