package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1}};

        List<Integer> l = new SpiralMatrix().spiralOrder(arr);
        for (int i : l) {
            System.out.print(i + " ");
        }

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> l = new ArrayList<>();

        if (matrix == null || matrix[0].length == 0) {
            return l;
        } else {

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
                            l.add(matrix[sRow][sCol]);
                            sCol++;
                            cnt++;
                        }
                        sRow++;
                        sCol--;
                    } else {
                        while (cnt <= colCount) {
                            l.add(matrix[sRow][sCol]);
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
                            l.add(matrix[sRow][sCol]);
                            sRow++;
                            cnt++;
                        }
                        sCol--;
                        sRow--;
                    } else {
                        while (cnt <= rowCount) {
                            l.add(matrix[sRow][sCol]);
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

            return l;
        }
    }
}
