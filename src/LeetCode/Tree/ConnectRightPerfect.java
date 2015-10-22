package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by prashantgolash on 10/21/15.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class ConnectRightPerfect {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode save = root;
            while (root != null) {
                if (root.left != null) {
                    root.left.next = root.right;
                }
                if (root.right != null && root.next != null) {
                    root.right.next = root.next.left;
                }

                root = root.next;
            }

            root = save.left;
        }
    }
}
