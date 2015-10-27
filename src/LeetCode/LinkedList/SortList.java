package LeetCode.LinkedList;


/**
 * Created by prashantgolash on 10/25/15.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        } else {
            ListNode middle = findMiddle(head);
            ListNode save = middle.next;

            middle.next = null;

            ListNode a = mergeSort(head);
            ListNode b = mergeSort(save);

            ListNode newHead = merge(a, b);
            return newHead;
        }
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode tempNode = new ListNode(-1);
        ListNode saveNode = tempNode;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tempNode.next = a;
                a = a.next;
            } else {
                tempNode.next = b;
                b = b.next;
            }
            tempNode = tempNode.next;
        }
        while (a != null) {
            tempNode.next = a;
            tempNode = tempNode.next;
            a = a.next;
        }
        while (b != null) {
            tempNode.next = b;
            tempNode = tempNode.next;
            b = b.next;
        }
        return saveNode.next;
    }
}