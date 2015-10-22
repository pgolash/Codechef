package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class RightSideView {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) {
            return l;
        } else {
            Queue<TreeNode> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
                Queue<TreeNode> newQ = new LinkedList<>();
                while (!q.isEmpty()) {
                    TreeNode n = q.remove();
                    if (q.isEmpty()) {
                        l.add(n.val);
                    }

                    if (n.left != null) {
                        newQ.add(n.left);
                    }
                    if (n.right != null) {
                        newQ.add(n.right);
                    }
                }
                q = newQ;
            }

            return l;
        }
    }
}
