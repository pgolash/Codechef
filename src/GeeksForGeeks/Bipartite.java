package GeeksForGeeks;

import LeetCode.LinkedList.LinkedListCycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by prashantgolash on 18/12/15.
 */
public class Bipartite {

    class GraphNode {
        int color;
        int val;
        List<GraphNode> neighbors;

        GraphNode(int val) {
            this.color = -1;
            this.val = val;
        }

    }

    public boolean bipartite(GraphNode root) {
        Queue<GraphNode> q = new LinkedList();
        q.add(root);
        root.color = 0;

        while(!q.isEmpty()) {
            GraphNode p = q.remove();
            int c = p.color;
            for (GraphNode n : p.neighbors) {
                if (n.color == p.color) {
                    return false;
                } else {
                    // not visited
                    if (n.color == -1) {
                        n.color = (p.color + 1) % 2;
                        q.add(n);
                    }
                }
            }
        }

        return true;

    }

}
