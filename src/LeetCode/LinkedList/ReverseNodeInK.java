package LeetCode.LinkedList;

import java.util.List;

/**
 * Created by prashantgolash on 9/20/15.
 */

public class ReverseNodeInK {

    public static void main(String[] args) {
        ReverseNodeInK rK = new ReverseNodeInK();
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode r = rK.reverseKGroup(head, 2);
        rK.print(r);

    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        boolean isDone = false;
        ListNode temp = head;
        ListNode prevHead = null;

        while (!isDone) {
            // advance node won't disturb temp
            // It will return the last node if we move k ahead
            ListNode kMoveAheadNode = advanceNode(temp, k);

            if (kMoveAheadNode == null) {
                isDone = true;
                if (prevHead != null) {
                    prevHead.next = temp;
                }
            } else {

                ListNode save = kMoveAheadNode.next;
                kMoveAheadNode.next = null;

                // reverse won't disturb temp
                ListNode newHead = reverse(temp);

                if (prevHead != null) {
                    prevHead.next = newHead;
                } else {
                    head = newHead;
                }

                prevHead = temp;
                temp = save;
            }

        }

        return head;
    }

    public ListNode reverse(ListNode head) {

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

    public ListNode advanceNode (ListNode head, int k) {

        if (head == null) {
            return null;
        } else {
            int cnt = 1;
            ListNode temp = head;
            ListNode save = temp;

            temp = temp.next;

            while (temp != null && cnt < k) {
                save = temp;
                temp = temp.next;
                cnt++;
            }

            if (cnt < k) {
                return null;
            } else {
                return save;
            }
        }
    }
}
