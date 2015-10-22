package LeetCode.Tree;

import java.util.*;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> answerL = new ArrayList<List<Integer>>();
        if (root == null) {
            return answerL;

        } else {

            Stack<List<Integer>> answer = new Stack<List<Integer>>();
            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (!q.isEmpty()) {
                Queue newQ = new LinkedList();

                List<Integer> l = new ArrayList<>();

                while(!q.isEmpty()) {
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
                answer.push(l);
            }

            while (!answer.isEmpty()) {
                answerL.add(answer.pop());
            }

            return answerL;
        }
    }

}
