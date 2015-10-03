package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode originalNode = new ListNode(-1);
        ListNode tempNode = originalNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }

        while (l1 != null) {
            tempNode.next = l1;
            l1 = l1.next;
            tempNode = tempNode.next;
        }

        while (l2 != null) {
            tempNode.next = l2;
            l2 = l2.next;
            tempNode = tempNode.next;
        }

        tempNode.next = null;
        return originalNode.next;

    }
}
