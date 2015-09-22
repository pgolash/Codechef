package LeetCode.Tree;

/**
 * Created by prashantgolash on 9/22/15.
 */

public class RecoverBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);

        new RecoverBST().recoverTree(root);

    }

    class Wrapper {
        TreeNode first;
        TreeNode second;
        TreeNode prev;

        Wrapper() {
            this.first = this.second = this.prev = null;
        }
    }

    public void recoverTree(TreeNode root) {
        Wrapper wrapper = new Wrapper();

        if (root == null) {
            return;
        } else {
            TreeNode first = null;
            TreeNode second = null;
            recoverTree(root, wrapper);

                int temp = wrapper.first.val;
                wrapper.first.val = wrapper.second.val;
                wrapper.second.val = temp;
        }
    }

    public void recoverTree(TreeNode node, Wrapper wrapper) {
        if (node != null) {
            recoverTree(node.left, wrapper);
            if (wrapper.prev != null) {
                if (wrapper.prev.val > node.val) {
                    if (wrapper.first == null) {
                        wrapper.first = wrapper.prev;
                    }
                    wrapper.second = node;
                }
            }
            wrapper.prev = node;
            recoverTree(node.right, wrapper);
        }
    }
}
