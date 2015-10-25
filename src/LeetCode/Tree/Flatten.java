package LeetCode.Tree;
import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class Flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.right = new TreeNode(11);

        new Flatten().flatten(root);

        while(root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        } else {
            Stack<TreeNode> stk = new Stack<>();
            boolean isDone = false;
            while (!isDone) {
               if (root.left == null) {
                   if (root.right != null) {
                       root = root.right;
                   } else {
                       if (stk.isEmpty()) {
                           isDone = true;
                       } else {
                           root.right = stk.pop();
                           root = root.right;
                       }
                   }
               } else {
                   if (root.right != null) {
                       stk.push(root.right);
                   }
                   TreeNode save = root.left;
                   root.left = null;
                   root.right = save;
                   root = save;
               }
            }
        }
    }
}