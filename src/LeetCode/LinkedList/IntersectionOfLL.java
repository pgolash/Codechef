package LeetCode.LinkedList;

import java.util.List;

/**
 * Created by prashantgolash on 9/29/15.
 */
public class IntersectionOfLL {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        head1.next.next = null;

        ListNode head2 = head1.next;

        ListNode get = new IntersectionOfLL().getIntersectionNode(head1, head2);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;

        if (len1 > len2) {
            int cnt = 1;
            while (tempA != null &&  cnt <= (len1 - len2)) {
                tempA = tempA.next;
                cnt++;
            }
        } else {
            int cnt = 1;
            while (tempB != null &&  cnt <= (len2 - len1)) {
                tempB = tempB.next;
                cnt++;
            }
        }

        while(tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if (tempA == tempB && tempA != null) {
            return tempA;
        } else {
            return null;
        }
    }

    public void move(ListNode temp, int move) {
    }

    public int length(ListNode head) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }
}
