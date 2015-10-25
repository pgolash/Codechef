package LeetCode.Uber;

import LeetCode.Tree.IterativePostOrderTraversal;
import apple.laf.JRSUIUtils;

import java.util.TreeMap;

/**
 * Created by prashantgolash on 10/25/15.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class DeleteBST {

    public TreeNode deleteNode(TreeNode root, int data) {
        TreeNode parent = null;
        boolean found = false;
        TreeNode newRoot = root;

        while (!found) {
            if (root.val == data) {
                found = true;
                break;
            } else {
                parent = root;
                if (root.val < data) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }

        if (found) {
            // do the deletion
            if (root.left == null && root.right == null) {
                if (parent.left == root) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (root.left == null) {
                if (parent == null) {
                  newRoot = root.right;
                } else {
                    if (parent.left == root) {
                        parent.left = root.right;
                    } else {
                        parent.right = root.right;
                    }
                }
            } else if (root.right == null) {
                if (parent == null) {
                    newRoot = root.right;
                }
                if (parent.left == root) {
                    parent.left = root.left;
                } else {
                    parent.right = root.left;
                }
            } else {
                // find inorder successor of root node
                TreeNode temp = root.right;
                TreeNode parentTemp = root.right;
                while (temp.left != null) {
                    parentTemp = temp;
                    temp = temp.left;
                }

                // we got root and parent, we got temp and parent
                parentTemp.left = temp.right;
                temp.left = root.left;
                temp.right = root.right;

                if (parent == null) {
                    newRoot = temp;
                } else {
                    if (parent.left == root) {
                        parent.left = temp;
                    } else {
                        parent.right = temp;
                    }
                }
            }
        }

        return newRoot;

    }
}
