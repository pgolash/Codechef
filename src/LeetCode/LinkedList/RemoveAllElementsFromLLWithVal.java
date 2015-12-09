package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class RemoveAllElementsFromLLWithVal {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode newHead = head;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    newHead = curr.next;
                }
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return newHead;

    }
}
