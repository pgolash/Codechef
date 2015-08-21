package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 8/19/15.
 */
public class DeleteNodeSinglyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            ListNode temp = node.next.next;
            node.next = null;
            node.next = temp;
        }
    }
}
