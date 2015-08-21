package LeetCode.Tree;

/**
 * Created by prashantgolash on 8/19/15.
 */
public class MaximumDepth {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public class Solution {

        class WrapperObj {
            int depth;

            WrapperObj() {
                this.depth = 0;
            }
        };

        public int maxDepth(TreeNode root) {
            WrapperObj obj = new WrapperObj();
            maxDepthWrapper(root, obj, 1);

            return obj.depth;
        }

        public void maxDepthWrapper(TreeNode root, WrapperObj obj, int depth) {
            if (root == null) {
                return;
            } else if (root.left == null && root.right == null) {
                obj.depth = Math.max(obj.depth, depth);
            } else {
                maxDepthWrapper(root.left, obj, depth + 1);
                maxDepthWrapper(root.right, obj, depth + 1);
            }
        }
    }
}
