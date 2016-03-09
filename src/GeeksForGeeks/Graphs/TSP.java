package GeeksForGeeks.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class TSP {

//    Let the given set of vertices be {1, 2, 3, 4,….n}. Let us consider 1 as starting and ending point of output.
//    For every other vertex i (other than 1), we find the minimum cost path with 1 as the starting point, i as the ending point and all vertices appearing exactly once. Let the cost of this path be cost(i), the cost of corresponding Cycle would be cost(i) + dist(i, 1) where dist(i, 1) is the distance from i to 1. Finally, we return the minimum of all [cost(i) + dist(i, 1)] values. This looks simple so far. Now the question is how to get cost(i)?
//    To calculate cost(i) using Dynamic Programming, we need to have some recursive relation in terms of sub-problems.
//    Let us define a term C(S, i) be the cost of the minimum cost path visiting each vertex in set S exactly once, starting at 1 and ending at i.
//    We start with all subsets of size 2 and calculate C(S, i) for all subsets where S is the subset, then we calculate C(S, i)
//    for all subsets S of size 3 and so on. Note that 1 must be present in every subset.
//
//    If size of S is 2, then S must be {1, i},
//    C(S, i) = dist(1, i)
//    Else if size of S is greater than 2.
//    C(S, i) = min { C(S-{i}, j) + dis(j, i)} where j belongs to S, j != i and j != 1.
//    For a set of size n, we consider n-2 subsets each of size n-1 such that all subsets don’t have nth in them.
//    Using the above recurrence relation, we can write dynamic programming based solution. There are at most O(n*2n) subproblems, and each
//    one takes linear time to solve. The total running time is therefore O(n2*2n). The time complexity is much less than O(n!), but still
//    exponential. Space required is also exponential. So this approach is also infeasible even for slightly higher number of vertices.
//

        public static void main(String[] args) throws NumberFormatException,
                IOException {
            BufferedReader buf = new BufferedReader(
                    new InputStreamReader(System.in));
            int t = Integer.parseInt(buf.readLine());

            while (t-- > 0) {
                String[] line = buf.readLine().split(" ");
                line = buf.readLine().split(" ");
                int sX = Integer.parseInt(line[0]);
                int sY = Integer.parseInt(line[1]);
                int n = Integer.parseInt(buf.readLine());
                int[][] matrix = new int[n + 1][n + 1];
                int[][] points = new int[n + 1][2];
                points[0][0] = sX;
                points[0][1] = sY;
                for (int i = 1; i <= n; i++) {
                    line = buf.readLine().split(" ");
                    int x = Integer.parseInt(line[0]);
                    int y = Integer.parseInt(line[1]);
                    points[i][0] = x;
                    points[i][1] = y;
                }
                for (int i = 0; i <= n; i++)
                    for (int j = 0; j <= n; j++) {
                        matrix[i][j] = matrix[j][i] = Math.abs(points[j][0]
                                - points[i][0])
                                + Math.abs(points[j][1] - points[i][1]);
                    }
                int[][] dp = new int[n + 1][(1 << (n + 1)) + 1];
                for (int i = 0; i < dp.length; i++)
                    Arrays.fill(dp[i], -1);

                int min = TSP(0, 0, dp, matrix);
                System.out.printf("The shortest path has length %d\n", min);
            }
        }

        private static int TSP(int node, int bitmask, int[][] dp, int[][] matrix) {
            if (bitmask == (1 << dp.length) - 1 && node == 0)
                return 0;
            if (bitmask == (1 << dp.length) - 1)
                return 100000;
            else if (dp[node][bitmask] != -1)
                return dp[node][bitmask];
            else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < dp.length; i++)
                    if ((bitmask & (1 << i)) == 0) {
                        min = Math.min(
                                min,
                                matrix[node][i]
                                        + TSP(i, bitmask | (1 << i), dp, matrix));

                    }
                return dp[node][bitmask] = min;
            }
        }
    }