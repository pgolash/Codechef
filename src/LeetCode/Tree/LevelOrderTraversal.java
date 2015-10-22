package LeetCode.Tree;

import java.util.*;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answerL = new ArrayList<List<Integer>>();
        if (root == null) {
            return answerL;

        } else {

            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (!q.isEmpty()) {
                Queue newQ = new LinkedList();

                List<Integer> l = new ArrayList<>();

                while (!q.isEmpty()) {
                    TreeNode node = q.remove();
                    if (node.left != null) {
                        newQ.add(node.left);
                    }
                    if (node.right != null) {
                        newQ.add(node.right);
                    }

                    l.add(node.val);
                }

                q = newQ;
                answerL.add(l);
            }

            return answerL;
        }
    }
}
