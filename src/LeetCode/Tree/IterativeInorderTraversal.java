package LeetCode.Tree;

import java.util.*;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class IterativeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        boolean isDone = false;

        while (!isDone) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                if (stk.isEmpty()) {
                    isDone = true;
                } else {
                    node = stk.pop();
                    l.add(node.val);
                    node = node.right;
                }
            }
        }

        return l;
    }
}
