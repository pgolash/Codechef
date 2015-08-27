package LeetCode.Tree;

/**
 * Created by prashant on 8/25/2015.
 */
public class ValidBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {


    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTWrapper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTWrapper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        } else {
            return root.val > min && root.val < max && isValidBSTWrapper(root.left, min, root.val) && isValidBSTWrapper(root.right, root.val, max);
        }
    }
}
