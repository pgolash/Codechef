package LeetCode.Tree;

/**
 * Created by prashantgolash on 21/01/16.
 */

public class TreeToDoublyLL {

    class Wrapper {
        TreeNode n;
        Wrapper() {
            n = new TreeNode(-2);
        }
    }

    public TreeNode treeToDoublyLL(TreeNode root) {
        Wrapper wrap = new Wrapper();
        Wrapper wrap1 = new Wrapper();
        wrap1.n = null;
        TreeNode prev = null;
        treeToDoublyLL(root, wrap1, wrap);
        return wrap.n;
    }

    public void treeToDoublyLL(TreeNode root, Wrapper prev, Wrapper wrap) {
        if (root == null) {
            return;
        } else {
            treeToDoublyLL(root.left, prev, wrap);

            root.left = prev.n;
            if (prev.n == null) {
                wrap.n = root;
            } else {
                prev.n.right = root;
            }

            prev.n = root;

            // 8 -><- 10 ><- 12
            treeToDoublyLL(root.right, prev, wrap);
        }

    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(12);
        x.left = new TreeNode(13);
        x.right = new TreeNode(15);

        TreeNode n = new TreeToDoublyLL().treeToDoublyLL(x);
    }
}
