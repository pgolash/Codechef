package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = null;

        ListNode s = new PartitionList().partition(head, 2);

        while (s != null ) {
            System.out.print(s.val + " ");
            s = s.next;
        }
        System.out.println();

    }

    public ListNode partition(ListNode head, int x) {

        ListNode saveGreat = null;
        ListNode saveLess = null;
        ListNode newhead = null;
        ListNode newHead1 = null;

        while (head != null) {
            if (head.val < x) {
                if (saveLess == null) {
                    newhead = head;
                    saveLess = head;
                } else {
                    saveLess.next = head;
                    saveLess = saveLess.next;
                }
            } else {
                if (saveGreat == null) {
                    saveGreat = head;
                    newHead1 = head;
                } else {
                    saveGreat.next = head;
                    saveGreat = saveGreat.next;
                }
            }
            head = head.next;
        }

        if (saveGreat != null) {
            saveGreat.next = null;
        }
        if (saveLess == null) {
            newhead = newHead1;
        } else {
            saveLess.next = newHead1;
        }

        return newhead;
    }
}
