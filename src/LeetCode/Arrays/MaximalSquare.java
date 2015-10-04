package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] cr = {
                        {'1','1'},
                        {'1','1'}
                      };
        System.out.println(new MaximalSquare().maximalSquare(cr));
    }

    class Data {
        int rowOnes;
        int colOnes;
        int squareSize;

        Data() {
            this.rowOnes = this.colOnes = this.squareSize = 0;
        }
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        } else {

            int rowLength = matrix.length;
            int colLength = matrix[0].length;
            int maxSquare = 0;

            Data[][] data = new Data[rowLength][colLength];
            data[0][0] = new Data();

            if (matrix[0][0] == '1') {
                data[0][0].rowOnes = data[0][0].colOnes = data[0][0].squareSize = 1;
                maxSquare = 1;
            }

            for (int j = 1; j < colLength; j++) {
                data[0][j] = new Data();
                if (matrix[0][j] == '1') {
                    data[0][j].rowOnes = data[0][j - 1].rowOnes + 1;
                    data[0][j].colOnes = 1;
                    data[0][j].squareSize = 1;
                    maxSquare = 1;
                }
            }

            for (int i = 1; i < rowLength; i++) {
                data[i][0] = new Data();
                if (matrix[i][0] == '1') {
                    data[i][0].colOnes = data[i - 1][0].colOnes + 1;
                    data[i][0].rowOnes = 1;
                    data[i][0].squareSize = 1;
                    maxSquare = 1;
                }
            }

            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < colLength; j++) {
                    data[i][j] = new Data();
                    if (matrix[i][j] == '1') {
                        data[i][j].colOnes = data[i - 1][j].colOnes + 1;
                        data[i][j].rowOnes = data[i][j - 1].rowOnes + 1;
                        data[i][j].squareSize = Math.min(Math.min(data[i][j - 1].rowOnes, data[i - 1][j].colOnes),
                                data[i - 1][j - 1].squareSize) + 1;

                        maxSquare = Math.max(maxSquare, data[i][j].squareSize);
                    }
                }
            }

            return maxSquare * maxSquare;
        }
    }
}
