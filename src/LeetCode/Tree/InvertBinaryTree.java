package LeetCode.Tree;

import apple.laf.JRSUIUtils;

import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class InvertBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            } else {
                TreeNode x = invertTree(root.left);
                TreeNode y = invertTree(root.right);

                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;

                return root;
            }

        }
    }
}
