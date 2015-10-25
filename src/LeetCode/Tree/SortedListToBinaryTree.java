package LeetCode.Tree;

import java.util.List;

/**
 * Created by prashantgolash on 10/24/15.
 */

   class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

public class SortedListToBinaryTree {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = null;
        TreeNode m =  new SortedListToBinaryTree().sortedListToBST(n);
        new SortedListToBinaryTree().inorder(m);
    }

    public void inorder(TreeNode n) {
        if (n != null) {
            inorder(n.left);
            System.out.println(n.val);
            inorder(n.right);
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else {
            ListNode justBeforeMiddle = findMiddle(head);
            ListNode save = justBeforeMiddle.next;

            justBeforeMiddle.next = null;

            TreeNode root = new TreeNode(save.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(save.next);
            return root;
        }
    }

    // return node just before middle
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return prev;
    }
}
