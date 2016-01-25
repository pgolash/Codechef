package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashSet<Integer>[] neighbors = new HashSet[n];
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> leafs = new ArrayList<>();
        int[] degrees = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (neighbors[a] == null) {
                neighbors[a] = new HashSet<>();
            }
            if (neighbors[b] == null) {
                neighbors[b] = new HashSet<>();
            }
            neighbors[a].add(b);
            neighbors[b].add(a);
            degrees[a]++;
            degrees[b]++;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                leafs.add(i);
            }
        }

        while ( visited.size() < n - 2) {
            ArrayList<Integer> nextLevel = new ArrayList<>();
            for (int i = 0; i < leafs.size(); i++) {
                int leaf = leafs.get(i);
                visited.add(leaf);
                HashSet<Integer> connectedToLeaf = neighbors[leaf];
                for (int connect : connectedToLeaf) {
                    if (!visited.contains(connect)) {
                        degrees[connect]--;
                        if (degrees[connect] == 1) {
                            nextLevel.add(connect);
                        }
                    }
                }
            }
            leafs = nextLevel;
        }
        return leafs;
    }
}
