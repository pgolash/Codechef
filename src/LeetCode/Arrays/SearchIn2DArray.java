package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1}};
        System.out.println(new SearchIn2DArray().searchMatrix(arr, 2));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int colIdx = matrix[0].length - 1;
        int rowIdx = 0;
        boolean isDone = false;
        boolean found = false;

        while (!isDone) {
            if (matrix[rowIdx][colIdx] == target) {
                isDone = true;
                found = true;
            } else if (matrix[rowIdx][colIdx] > target) {
                colIdx--;
            } else {
                rowIdx++;
            }

            if (colIdx < 0 || rowIdx >= matrix.length) {
                isDone = true;
            }
        }

        return isDone;
    }
}
