package LeetCode.LinkedList;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;
        System.out.println(new LinkedListCycleII().detectCycle(node));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        } else {
            ListNode slow = head;;
            ListNode fast = head;

            do {
                slow = slow.next;
                fast = fast.next.next;
            } while (fast != null && fast.next != null && slow != fast);

            if (fast == null || fast.next == null) {
                return null;
            } else {
                int length = cycleLength(slow);
                ListNode advance = advanceNode(head, length);
                slow = head;

                while (slow != advance) {
                    slow = slow.next;
                    advance = advance.next;
                }

                return slow;
            }
        }
    }

    public ListNode advanceNode(ListNode head, int cnt) {
        int tCnt = 1;
        while (tCnt <= cnt) {
            head = head.next;
            tCnt++;
        }
        return head;
    }

    public int cycleLength(ListNode slow) {
        int cnt = 1;
        ListNode save = slow;
        while (slow.next != save) {
            slow = slow.next;
            cnt++;
        }

        return cnt;
    }
}
