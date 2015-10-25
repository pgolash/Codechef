package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode newHead = head;
        while (temp != null && temp.next != null) {
            ListNode save = temp.next.next;
            ListNode save1 = temp.next;
            temp.next.next = temp;
            temp.next = save;
            if (prev != null) {
                prev.next = save1;
            } else {
                newHead = save1;
            }
            prev = temp;
            temp = save;
        }
        return newHead;
    }
}