package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n == 0) {
            return matrix;
        } else {

            int numCnt = 1;


            int rowCount = matrix.length - 1;
            int colCount = matrix[0].length;

            int sRow = 0;
            int sCol = 0;

            boolean rowIncrease = true;
            boolean colIncrease = true;

            boolean rowTurn = true;
            boolean isDone = false;
            int cnt;

            while (!isDone) {
                if (rowTurn) {
                    isDone = colCount < 1;
                    cnt = 1;
                    if (rowIncrease) {
                        while (cnt <= colCount) {
                            matrix[sRow][sCol] = numCnt++;
                            sCol++;
                            cnt++;
                        }
                        sRow++;
                        sCol--;
                    } else {
                        while (cnt <= colCount) {
                            matrix[sRow][sCol] = numCnt++;
                            sCol--;
                            cnt++;
                        }
                        sRow--;
                        sCol++;
                    }

                    colCount--;
                    rowIncrease = !rowIncrease;

                } else {
                    cnt = 1;
                    isDone = rowCount < 1;
                    if (colIncrease) {
                        while (cnt <= rowCount) {
                            matrix[sRow][sCol] = numCnt++;
                            sRow++;
                            cnt++;
                        }
                        sCol--;
                        sRow--;
                    } else {
                        while (cnt <= rowCount) {
                            matrix[sRow][sCol] = numCnt++;
                            sRow--;
                            cnt++;
                        }
                        sCol++;
                        sRow++;
                    }

                    rowCount--;
                    colIncrease = !colIncrease;
                }

                rowTurn = !rowTurn;
            }

            return matrix;
        }
    }
}
