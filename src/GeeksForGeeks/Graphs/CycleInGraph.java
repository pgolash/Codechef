package GeeksForGeeks.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 06/01/16.
 */

class Graph {
    private int numVertices;
    private List<Integer> x[];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        x = new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        x[source].add(destination);
    }

    public Iterator<Integer> getEdgeIterator(int source) {
        return x[source].iterator();
    }

    public int getNumVertices() {
        return numVertices;
    }
}

public class CycleInGraph {

    public boolean detectCycle(Graph g) {
        boolean[] visited = new boolean[g.getNumVertices()];
        boolean[] done = new boolean[g.getNumVertices()];

        Arrays.fill(visited, false);
        Arrays.fill(done, false);

        for (int i = 0; i < g.getNumVertices(); i++) {
            if (!visited[i]) {
                boolean x = detectCycle(i, g, visited, done);
                if (x) {
                    return x;
                }
            }
        }

        return false;
    }

    public boolean detectCycle(int node, Graph g, boolean[] visited, boolean[] done) {
        visited[node] = true;
        while(g.getEdgeIterator(node).hasNext()) {
            Integer neigh = g.getEdgeIterator(node).next();
            if (!visited[neigh]) {
                detectCycle(neigh, g, visited, done);
            } else if (!done[neigh]) {
                return true;
            }
        }
        done[node] = true;
        return false;
    }

}
