package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class IterativePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        boolean isDone = false;
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (!isDone) {
            if (root != null) {
                l.add(root.val);
                if (root.right != null) {
                    stk.push(root.right);
                }
                root = root.left;
            } else {
                if (stk.isEmpty()) {
                    isDone = true;
                } else {
                    root = stk.pop();
                }
            }
        }

        return l;

    }
}
