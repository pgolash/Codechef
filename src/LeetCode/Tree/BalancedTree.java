package LeetCode.Tree;

import apple.laf.JRSUIUtils;

/**
 * Created by prashantgolash on 10/1/15.
 */
public class BalancedTree {
    class Wrapper {
        boolean balanced;
        Wrapper() {
            balanced = true;
        }
    }

    public boolean isBalanced(TreeNode root) {
        Wrapper wrap = new Wrapper();
        isBalanced(root, wrap);
        return wrap.balanced;
    }

    public int isBalanced(TreeNode root, Wrapper wrap) {
        if (root == null) {
            return 0;
        } else {
            int leftH = isBalanced(root.left, wrap);
            if (wrap.balanced) {
                int rightH = isBalanced(root.right, wrap);
                wrap.balanced = wrap.balanced && Math.abs(rightH - leftH) <= 1;
                return Math.max(leftH, rightH) + 1;
            } else {
                return -1;
            }
        }
    }
}