package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/01/16.
 */
public class BinaryTreeLongestConsecutivesum {
    private int result = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 0, root);
        return result;
    }
    private void dfs(TreeNode root, int cur, TreeNode pre) {
        if(root == null)
            return;
        if(root.val == pre.val+1)
            cur++;
        else
            cur = 1;
        result = Math.max(result, cur);
        dfs(root.left, cur, root);
        dfs(root.right, cur, root);
    }
}
