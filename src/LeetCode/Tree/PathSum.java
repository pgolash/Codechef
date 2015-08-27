package LeetCode.Tree;

/**
 * Created by prashant on 8/25/2015.
 */
public class PathSum {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.right == null && root.left == null && sum == root.val) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
