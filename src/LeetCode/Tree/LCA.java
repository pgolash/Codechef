package LeetCode.Tree;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class LCA {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) {
                return null;
            } else {
                TreeNode LCA = null;

                if (root == p || root == q) {
                    LCA = root;
                }

                TreeNode left = lowestCommonAncestor(root.left, p, q);
                TreeNode right = lowestCommonAncestor(root.right, p, q);

                if (left == null && right == null) {
                    return LCA;
                } else if (left == null) {
                    return LCA == null ? right : LCA;
                } else if (right == null) {
                    return LCA == null ? left : LCA;
                } else {
                    return root;
                }
            }
        }
    }
}
