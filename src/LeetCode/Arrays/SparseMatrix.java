package LeetCode.Arrays;

/**
 * Created by prashantgolash on 29/12/15.
 */
public class SparseMatrix {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0)
                    for (int j = 0; j < B[0].length; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
            }
        }
        return C;
    }
}
