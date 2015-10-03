package LeetCode.LinkedList;

import java.util.List;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        } else {
            ListNode save = head.next;
            head.next = null;

            while (save != null) {
                ListNode save1 = save.next;

                head = insertNode(head, save);
                save = save1;
            }

            return head;
        }
    }

    public ListNode insertNode(ListNode node, ListNode elem) {
        ListNode prev = null;
        ListNode save = node;
        while (node != null && node.val < elem.val) {
            prev = node;
            node = node.next;
        }

        if (prev == null) {
            elem.next = node;
            return elem;
        }

        prev.next = elem;
        elem.next = node;

        return save;
    }
}
