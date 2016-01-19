package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/01/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        // Create an adj list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];

        if (!validTreeHelper(n, edges, 0, -1, visited, adjList)) {
            return false;
        }

        // Check the islands
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean validTreeHelper(int n, int[][] edges, int vertexId, int parentId,
                                    boolean[] visited, List<List<Integer>> adjList) {
        if (visited[vertexId]) {
            return false;
        }

        visited[vertexId] = true;

        List<Integer> neighbors = adjList.get(vertexId);
        for (Integer neighbor : neighbors) {
            if (neighbor != parentId && !validTreeHelper(n, edges, neighbor, vertexId, visited, adjList)) {
                return false;
            }
        }

        return true;
    }
}
