package LeetCode.LinkedList;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by pgolash on 8/23/2015.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        ListNode newHead = reverse(middle.next);
        middle.next = null;

        reorderList(head, newHead);
    }

    // for even nodes for e.g with length 4 return 2rd node
    // for odd nodes for e.g. with length 5 return 3rd node
    public ListNode findMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;

        while(node != null) {
            ListNode save = node.next;
            if (prev != null) {
                node.next = prev;
            }
            prev = node;
            node = save;
        }

        return prev;
    }


    public void reorderList(ListNode head, ListNode newHead) {

        boolean flag = true;
        ListNode dummyNode = new ListNode(-1);
        ListNode savedNode = dummyNode;

        // Rearranging the lists
        while(head != null && newHead != null) {
            if (flag) {
                dummyNode.next = head;
                head = head.next;
            } else {
                dummyNode.next = newHead;
                newHead = newHead.next;
            }

            flag = !flag;
            dummyNode = dummyNode.next;
        }

        while (head!=null) {
            dummyNode.next = head;
            dummyNode = dummyNode.next;
            head = head.next;
        }

        dummyNode.next = null;
        savedNode.next = null;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(12);
        node1.next = new ListNode(13);
        node1.next.next = new ListNode(14);
        node1.next.next.next = null;

        new ReorderList().reorderList(node1);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}

