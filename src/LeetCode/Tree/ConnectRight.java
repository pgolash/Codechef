package LeetCode.Tree;

import apple.laf.JRSUIUtils;

/**
 * Created by prashantgolash on 9/13/15.
 */
public class ConnectRight {

    public class TreeLinkNode {
            int val;
             TreeLinkNode left, right, next;
             TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        } else {
            root.next = null;

            boolean isDone = false;
            TreeLinkNode temp = root;

            while (!isDone) {
                TreeLinkNode save = temp;

                while (temp != null) {
                    if (temp.left != null) {
                        if (temp.right != null) {
                            temp.left.next = temp.right;
                        } else {
                            temp.left.next = getNext(temp);
                        }
                    }

                    if (temp.right != null) {
                        temp.right.next = getNext(temp);
                    }


                    temp = temp.next;
                }

                if (save.left != null) {
                    temp = save.left;
                } else if (save.right != null) {
                    temp = save.right;
                } else {
                    temp = getNext(save);
                }

                isDone = temp == null;
            }
        }
    }

    public TreeLinkNode getNext(TreeLinkNode node) {
        TreeLinkNode nnext = node.next;
        while (nnext != null) {
            if (nnext.left != null) {
                return nnext.left;
            }
            if (nnext.right != null) {
                return nnext.right;
            }
            nnext = nnext.next;
        }

        return null;
    }
}
