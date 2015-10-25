package LeetCode.Tree;

import apple.laf.JRSUIUtils;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/23/15.
 */
public class ConstructTreeFromPreAndInorder {

    public static void main(String[] args) {

        int[] pre = new int[] {10, 9, 8, 14};
        int[] ord = new int[] {8, 9, 10, 14};

        TreeNode n = new ConstructTreeFromPreAndInorder().buildTree(pre, ord);
        new ConstructTreeFromPreAndInorder().inorder(n);
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }


    class Wrapper {
        int preorderIdx;

        Wrapper() {
            this. preorderIdx = 0;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Wrapper wrap = new Wrapper();
        TreeNode node = constructTree(0, preorder.length - 1, preorder, inorder, wrap);
        return node;
    }

    public int getInorderIndex(int elem, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode constructTree(int low, int high, int[] preorder, int[] inorder, Wrapper wrap) {
        if (low > high) {
            return null;
        } else {
            int elem = preorder[wrap.preorderIdx++];
            int inorderIdx = getInorderIndex(elem, inorder);

            TreeNode root = new TreeNode(elem);
            root.left = constructTree(low, inorderIdx - 1, preorder, inorder, wrap);
            root.right = constructTree(inorderIdx + 1, high, preorder, inorder, wrap);
            return root;
        }
    }
}