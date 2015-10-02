package LeetCode.Tree;

import apple.laf.JRSUIUtils;

/**
 * Created by prashantgolash on 10/1/15.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null && left.val == right.val) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        }
    }
}
