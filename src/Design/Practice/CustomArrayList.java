package Design.Practice;

import java.io.InvalidClassException;
import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by prashantgolash on 8/8/15.
 */

// Custom List with any object within it
public class CustomArrayList<E> {

    private E myObjectList[];
    private int idx;
    private final static int DEFAULT_CAPACITY = 20;

    CustomArrayList() {
        myObjectList = (E[]) new Object[DEFAULT_CAPACITY];
        idx = 0;
    }

    public int size() {
        return idx;
    }

    private void resize() {
        try {
            Object newObjectList[] = new Object[2 * idx];
            for (int currIdx = 0; currIdx < idx; currIdx++) {
                newObjectList[currIdx] = myObjectList[currIdx];
            }
            myObjectList = (E[]) newObjectList;
        }
        catch (OutOfMemoryError e) {
            throw e;
        }
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < idx; i++) {
            if (myObjectList[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        List<E> myL = Arrays.asList(myObjectList);
        return myL.iterator();
    }

    public Object[] toArray() {
        return myObjectList;
    }


    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException();
        } else {

            Class<?> paramClass = a.getClass();
            boolean flag = paramClass.isAssignableFrom(myObjectList.getClass());

            if (flag) {
                if (a.length >= myObjectList.length) {
                    for (int currIdx = 0; currIdx < idx; currIdx++) {
                        // safe to case here
                        a[currIdx] = (T) myObjectList[currIdx];
                    }
                    return a;
                } else {
                    Object[] newObjectList = new Object[idx];
                    for (int currIdx = 0; currIdx < idx; currIdx++) {
                        newObjectList[currIdx] = myObjectList[currIdx];
                    }
                    return (T[])newObjectList;
                }
            } else {
                throw new ArrayStoreException();
            }
        }
    }


    public boolean add(E e) {
        try {
            if (idx == myObjectList.length) {
                resize();
            }
            myObjectList[idx++] = e;
            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
         return false;
        }
    }

    private void shift(int shiftIdx) {
        for (int currIdx = shiftIdx; currIdx < idx - 1; currIdx++) {
            myObjectList[currIdx] = myObjectList[currIdx + 1];
        }
    }

    public boolean remove(Object o) {
        for (int i = 0; i < idx; i++) {
            if (myObjectList[i].equals(o)) {
                myObjectList[i] = null;
                shift(i);
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        boolean containsAll = false;
        boolean[] mark = new boolean[idx];
        int cnt = 0;

        Arrays.fill(mark, false);
        Class t = myObjectList[0].getClass();

        Iterator<?> iter = c.iterator();

        while(iter.hasNext()) {
            Object o = iter.next();
            if (t.isAssignableFrom(o.getClass())) {
                boolean found = false;
                for (int i = 0; i < idx; i++) {
                    if (!mark[i] && myObjectList[i].equals(o)) {
                        mark[i] = true;
                        found = true;
                        break;
                    }
                }
                if (found) {
                    cnt++;
                } else {
                    break;
                }
            } else {
                throw new ClassCastException();
            }
        }

        if (cnt == c.size()) {
            containsAll = true;
        }

        return containsAll;
    }

    public boolean addAll(Collection<? extends E> c) {
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()){
            add((E)iter.next());
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return true;

    }

    public boolean removeAll(Collection<?> c) {
        return true;

    }

    public boolean retainAll(Collection<?> c) {
        return true;

    }

    public void clear() {

    }

    public boolean equals(Object o) {
        return true;

    }

    public int hashCode() {
        return 0;
    }

    public E get(int index) {
        return (E) myObjectList[index];
    }

    public E set(int index, E element) {
        return myObjectList[0];
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return myObjectList[0];

    }

    public int indexOf(Object o) {
        int retIdx = -1;
        for (int currIdx = 0; currIdx < idx; currIdx++) {
            if (myObjectList[currIdx].equals(o)) {
                retIdx = currIdx;
                break;
            }
        }
        return retIdx;
    }

    public int lastIndexOf(Object o) {
        int retIdx = -1;
        for (int currIdx = 0; currIdx < idx; currIdx++) {
            if (myObjectList[currIdx].equals(o)) {
                retIdx = currIdx;
            }
        }
        return retIdx;
    }
}