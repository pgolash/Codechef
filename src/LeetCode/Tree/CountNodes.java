package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int cnt = 0;
            boolean isDone = false;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            cnt = 1;

            while (!isDone) {
                Queue<TreeNode> newQ = new LinkedList<>();
                while (!q.isEmpty()) {
                    TreeNode n = q.remove();
                    if (n.left != null) {
                        cnt++;
                        newQ.add(n.left);
                    }
                    if (n.right != null) {
                        cnt++;
                        newQ.add(n.right);
                    }

                    if (n.left != null && n.right == null) {
                        isDone = true;
                    }
                }
                q = newQ;
                if (newQ.isEmpty()) {
                    isDone = true;
                }
            }
            return cnt;
        }
    }
}
