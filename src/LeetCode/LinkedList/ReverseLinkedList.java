package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else {

            ListNode prev = null;
            ListNode temp = head;
            ListNode save = null;

            while (temp != null) {
                save = temp.next;
                temp.next = prev;
                prev = temp;
                temp = save;
            }

            return prev;
        }
    }
}
