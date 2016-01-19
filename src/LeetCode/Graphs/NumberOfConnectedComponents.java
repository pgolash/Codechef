package LeetCode.Graphs;

import LeetCode.Arrays.IntegerToRoman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 10/01/16.
 */
public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            return 0;
        }

        if (n == 1 && edges.length == 0) {
            return 1;
        }

        int result = 0;
        boolean[] visited = new boolean[n];

        // step 1: create the adj list from edge list
        List[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adjList[from].add(to);
            adjList[to].add(from);
        }

        // step 2: calculate the number of cc
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                countCCHelper(i, adjList, visited);
            }
        }

        return result;
    }

    private void countCCHelper(int node, List[] adjList, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        List<Integer> neighbors = adjList[node];

        for (int neighbor : neighbors) {
            countCCHelper(neighbor, adjList, visited);
        }
    }
}
