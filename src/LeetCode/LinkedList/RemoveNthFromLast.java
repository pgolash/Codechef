package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class RemoveNthFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode x = advanceFirstNode(head, n - 1);
        ListNode temp = head;
        ListNode prev = null;

        while (x.next != null) {
            prev = temp;
            temp = temp.next;
            x = x.next;
        }

        if (temp == head) {
            ListNode save = temp.next;
            temp = null;
            head = save;
        } else {
            prev.next = temp.next;
            temp = null;
        }
        return head;
    }

    public ListNode advanceFirstNode(ListNode e, int cnt) {
        int tCnt = 1;
        while (tCnt <= cnt) {
            e = e.next;
            tCnt++;
        }
        return e;
    }
}
