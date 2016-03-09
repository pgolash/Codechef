package GeeksForGeeks.Tree;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by prashantgolash on 08/12/15.
 */

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}

public class TopView {

    class QueueObject {
        TreeNode node;
        int hDist;

        QueueObject(TreeNode node, int dist) {
            this.node = node;
            this.hDist = dist;
        }
    }

    public void getTopView(TreeNode root, Map<Integer, Integer> distMap) {
        if (root == null) {
            return;
        } else {
            boolean isDone = false;
            Queue<QueueObject> q = new LinkedList<>();
            q.add(new QueueObject(root, 0));

            distMap.put(0, root.val);

            while (!q.isEmpty()) {
                Queue<QueueObject> newQ = new LinkedList<>();
                while (!q.isEmpty()) {
                    QueueObject o = q.remove();
                    int hDist = o.hDist;

                    if (!distMap.containsKey(o.hDist)) {
                        distMap.put(hDist, o.node.val);
                    }

                    if (o.node.left != null) {
                        newQ.add(new QueueObject(o.node.left, hDist - 1));
                    }

                    if (o.node.right != null) {
                        newQ.add(new QueueObject(o.node.right, hDist + 1));
                    }
                }
                q = newQ;
            }
        }
    }
}