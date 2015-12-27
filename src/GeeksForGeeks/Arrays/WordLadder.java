package GeeksForGeeks.Arrays;

import java.util.*;

/**
 * Created by prashantgolash on 12/12/15.
 */
public class WordLadder {

    class GraphNode {
        String value;
        List<GraphNode> nodes;
        Integer dist;

        public GraphNode(String val) {
            this.value = val;
            nodes = new ArrayList<>();
        }
    }

    // put all nodes with infinity distance

    // for
    public static void main(String[] args) {

    }

    public int getMinDistance(String source, String dist, Set<String> wSet) {
        PriorityQueue<GraphNode> queue = new PriorityQueue<>(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode o1, GraphNode o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });

        return -1;
    }
}