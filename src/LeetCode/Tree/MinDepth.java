package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return minDepthW(root);
        }
    }

    public int minDepthW(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            int l = minDepthW(root.left);
            int r = minDepthW(root.right);

            if ((l != Integer.MIN_VALUE) && (r != Integer.MIN_VALUE)) {
                return Math.min(l, r) + 1;
            } else if (l != Integer.MIN_VALUE) {
                return  l + 1;
            } else if (r != Integer.MIN_VALUE) {
                return r + 1;
            } else {
                return 1;
            }
        }
    }
}
