package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class PalindromeLL {

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(1);
        System.out.println(new PalindromeLL().isPalindrome(n));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else {
            int length = getLength(head);
            ListNode advanceNode = advanceLinkedList(head, (length + 1) / 2);
            ListNode save = advanceNode.next;
            advanceNode.next = null;
            ListNode reverseNode = reverseList(save);

            return checkPalindrome(head, reverseNode);
        }
    }

    public int getLength(ListNode head) {
        int cnt = 0;

        while (head != null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }

    public ListNode advanceLinkedList(ListNode head, int size) {
        int cnt = 1;

        while (cnt < size) {
            head = head.next;
            cnt++;
        }

        return head;
    }

    public ListNode reverseList(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode save = node.next;
            node.next = prev;
            prev = node;
            node = save;
        }

        return prev;
    }

    public boolean checkPalindrome(ListNode head1, ListNode head2) {
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

}
