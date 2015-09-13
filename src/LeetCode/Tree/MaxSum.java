package LeetCode.Tree;

/**
 * Created by prashantgolash on 9/13/15.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class MaxSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-1);
        root.left = null;
        root.right.left = root.right.right = null;

        System.out.println(new MaxSum().maxPathSum(root));
    }


    class Wrapper {
        int maxSum;
        Wrapper() {
            maxSum = Integer.MIN_VALUE;
        }
    }

    public int maxPathSum(TreeNode root) {
        Wrapper w = new Wrapper();
        maxPathSum(root, w);
        return w.maxSum;
    }

    public int maxPathSum(TreeNode root, Wrapper w) {
        if (root == null) {
            return 0;
        } else {

            int leftMax = maxPathSum(root.left, w);
            int rightMax = maxPathSum(root.right, w);

            int maxReturnSum = root.val;

            int max = leftMax > rightMax ? leftMax : rightMax;

            if (max > 0) {
                maxReturnSum += max;
            }

            if (leftMax < 0) {
                leftMax = 0;
            }
            if (rightMax < 0) {
                rightMax = 0;
            }

            w.maxSum = Math.max(w.maxSum, root.val + rightMax + leftMax);

            return maxReturnSum;

        }

    }
}
