package LeetCode.Iterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 10/01/16.
 */
public class ZigZagIterator {
    private ListNode currPosition;

    class ListNode {
        Iterator<Integer> it;
        ListNode next;
        ListNode prev;
        ListNode(Iterator it) {
            this.it = it;
            this.next = null;
            this.prev = null;
        }
    }

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        currPosition = new ListNode(v1.iterator());
        currPosition.next = new ListNode(v2.iterator());

        currPosition.next.next = currPosition;
        currPosition.prev = currPosition.next;
        currPosition.next.prev = currPosition;

    }

    public int next() {
        int val = currPosition.it.next();
        currPosition = currPosition.next;
        return val;
    }

    public boolean hasNext() {
        boolean hasNext = true;

        while (!currPosition.it.hasNext()) {

            if (currPosition.next == currPosition) {
                hasNext = false;
                break;
            }

            currPosition.prev.next = currPosition.next;
            currPosition.next.prev = currPosition.prev;

            currPosition = currPosition.next;
        }

        return hasNext;
    }
}
