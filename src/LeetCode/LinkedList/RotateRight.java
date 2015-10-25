package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        new RotateRight().rotateRight(head, 5);


        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        } else {
            int lLen = getLen(head);
            k = k % lLen;

            ListNode tail = head;
            ListNode newhead = reverse(head);
            for (int i = 1; i <= k; i++) {
                tail.next = newhead;
                ListNode save = newhead.next;
                newhead.next = null;
                tail = newhead;
                newhead = save;
            }
            newhead = reverse(newhead);
            return newhead;
        }
    }

    int getLen(ListNode head) {
        int cnt = 1;
        while (head.next != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode save = head.next;
            head.next = prev;
            prev = head;
            head = save;
        }
        return prev;
    }
}
