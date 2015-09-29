package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null || head == null){
            return head;
        } else {
            boolean isDone = false;
            ListNode sNode;
            ListNode eNode;

            sNode = head;
            eNode = head.next;

            while (!isDone) {
                if (eNode.val == sNode.val) {

                    while (eNode != null && eNode.val == sNode.val) {
                        eNode = eNode.next;
                    }

                    sNode.next = eNode;
                    sNode = sNode.next;

                    if (eNode != null) {
                        eNode = eNode.next;
                    }

                } else {
                    sNode = sNode.next;
                    eNode = eNode.next;
                }

                isDone = eNode == null;
            }
        }

        return head;
    }
}
