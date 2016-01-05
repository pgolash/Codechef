package LeetCode.Tree;

import java.util.Stack;

/**
 * Created by prashantgolash on 03/01/16.
 */
public class BinaryTreeUpsideDown {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        new BinaryTreeUpsideDown().upsideDownBinaryTree(root);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {

            TreeNode newHead = null;
            TreeNode saveRight = null;
            TreeNode saveRightTemp = null;
            TreeNode prevRoot = null;

            while (root != null) {
                if (root.left == null) {
                    newHead = root;
                }

                saveRightTemp = root.right;
                TreeNode saveLeft = root.left;
                adjustPointers(root, prevRoot, saveRight);
                prevRoot = root;
                root = saveLeft;

                saveRight = saveRightTemp;
            }

            return newHead;
        }
    }

    public void adjustPointers(TreeNode orig, TreeNode left, TreeNode right) {
        orig.left = right;
        orig.right = left;
    }


}
