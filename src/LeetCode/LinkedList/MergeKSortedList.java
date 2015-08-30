package LeetCode.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by prashantgolash on 8/29/15.
 */
public class MergeKSortedList {

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }

    class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode x, ListNode y) {
            if (x.val < y.val) {
                return -1;
            } else if (x.val > y.val) {
                return 1;
            }
            return 0;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNodeComparator c = new ListNodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,c);

        for (ListNode x : lists) {
            if (x != null) {
                queue.add(x);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode savedNode = dummyNode;

        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();

            dummyNode.next = new ListNode(temp.val);
            dummyNode = dummyNode.next;

            temp = temp.next;
            if (temp != null) {
                queue.add(temp);
            }
        }

        while (!queue.isEmpty()) {
            dummyNode.next = new ListNode(queue.poll().val);
            dummyNode = dummyNode.next;
        }

        return savedNode.next;

    }
}
