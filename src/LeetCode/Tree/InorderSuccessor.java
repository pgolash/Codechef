package LeetCode.Tree;

/**
 * Created by prashantgolash on 05/01/16.
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        } else {
            TreeNode inorderSucc = null;
            boolean isDone = false;
            while (!isDone) {
                if (root == p) {
                    isDone = true;
                    if (root.right == null) {
                        return inorderSucc;
                    } else {
                        TreeNode x = root.right;
                        while (x.left != null) {
                            x = x.left;
                        }
                        inorderSucc = x;
                    }
                } else if (root.val < p.val) {
                    root = root.right;
                } else {
                    inorderSucc = root;
                    root = root.left;
                }
            }

            return inorderSucc;
        }
    }
}
