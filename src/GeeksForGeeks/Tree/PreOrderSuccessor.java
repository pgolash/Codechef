package GeeksForGeeks.Tree;

/**
 * Created by prashantgolash on 07/01/16.
 */
public class PreOrderSuccessor {
    public TreeNode getPreOrderSuccessor(TreeNode root, TreeNode n) {
        TreeNode succ = null;
        boolean isDone = false;
        while (!isDone) {
            if (root == n) {
                if (root.left != null) {
                    succ = root.left;
                } else if (root.right != null) {
                    succ = root.right;
                }
                isDone = true;
            } else if (root.val > n.val) {
                if (root.right != null) {
                    succ = root.right;
                    root = root.left;
                }
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}
