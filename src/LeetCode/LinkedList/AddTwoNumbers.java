package LeetCode.LinkedList;

/**
 * Created by prashant on 8/29/2015.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode saveNode = dummyNode;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            dummyNode.next = new ListNode(sum);
            dummyNode = dummyNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            dummyNode.next = new ListNode(sum);
            dummyNode = dummyNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            dummyNode.next = new ListNode(sum);
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            dummyNode.next = new ListNode(carry);
            dummyNode = dummyNode.next;
        }

        dummyNode.next = null;
        return saveNode.next;
    }

}
