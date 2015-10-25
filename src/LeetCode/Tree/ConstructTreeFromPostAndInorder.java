package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class ConstructTreeFromPostAndInorder {
    class Wrapper {
        int postorderIdx;
        Wrapper(int idx) {
            this.postorderIdx = idx;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Wrapper wrap = new Wrapper(postorder.length  - 1);
        TreeNode node = constructTree(0, postorder.length - 1, inorder, postorder, wrap);
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

    public TreeNode constructTree(int low, int high, int[] inorder, int[] postorder, Wrapper wrap) {
        if (low > high) {
            return null;
        } else {
            int elem = postorder[wrap.postorderIdx--];
            int inorderIdx = getInorderIndex(elem, inorder);

            TreeNode root = new TreeNode(elem);
            root.right = constructTree(inorderIdx + 1, high, inorder, postorder, wrap);
            root.left = constructTree(low, inorderIdx - 1, inorder, postorder, wrap);
            return root;
        }
    }
}