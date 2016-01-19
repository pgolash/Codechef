package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/01/16.
 */
class Wrapper {
    Integer tC;
    Wrapper() {
        tC = 0;
    }
}
public class CountUnivalueTrees {

    public int countUnivalSubtrees(TreeNode root) {
        Wrapper wrapper = new Wrapper();
        count(root, wrapper);
        return wrapper.tC;
    }

    public boolean count(TreeNode node, Wrapper wrap) {
        if (node == null) {
            return true;
        } else {
            boolean a = count(node.left, wrap);
            boolean b = count(node.right, wrap);
            boolean flag = false;

            if (a && b) {
                if (node.left == null && node.right == null) {
                    wrap.tC += 1;
                    flag = true;
                } else if (node.left == null) {
                    if (node.right.val == node.val) {
                        wrap.tC++;
                        flag = true;
                    }
                } else if(node.right == null) {
                    if (node.left.val == node.val) {
                        wrap.tC++;
                        flag = true;
                    }
                } else {
                    if (node.val == node.left.val && node.val == node.right.val) {
                        wrap.tC++;
                        flag = true;
                    }
                }
            }
            return flag;
        }
    }


}
