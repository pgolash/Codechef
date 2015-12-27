package LeetCode.Arrays;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class SearchIn2DArrayII {
    public int searchMatrix(int[][] matrix, int target) {
        int occurrence = 0;
        if (matrix == null || matrix[0] == null) {
            return occurrence;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                occurrence++;
                col--;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return occurrence;
    }
}
