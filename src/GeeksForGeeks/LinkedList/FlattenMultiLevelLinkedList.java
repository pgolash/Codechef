package GeeksForGeeks.LinkedList;

import LeetCode.LinkedList.MergeKSortedList;

/**
 * Created by prashantgolash on 31/12/15.
 */

class ListNode {
    ListNode next;
    ListNode child;
    int val;
}

public class FlattenMultiLevelLinkedList {
    public class Solution {
        public void flattenList(ListNode head) {
            if (head == null) {
                return;
            }

            // Step 1: get the tail of the list
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }

            // Step 2: iterate from the first layer. If a node has a child, put it to
            // the end of hte list, and update the tail pointer
            ListNode p = head;

            while (p != tail) {
                if (p.child != null) {
                    ListNode childHead = p.child;
                    tail.next = childHead;

                    // Updat the tail
                    while (tail.next != null) {
                        tail = tail.next;
                    }

                    p.child = null;
                }

                p = p.next;
            }
        }
    }
}
