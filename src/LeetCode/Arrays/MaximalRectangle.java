package LeetCode.Arrays;

/**
 * Created by pgolash on 9/16/2015.
 */
public class MaximalRectangle {

    class Dimension {
        int length;
        int height;

        Dimension() {
            this.length = this.height = 0;
        }
    }

    public int maximalRectangle(char[][] matrix) {

        int maxArea = 0;

        if (matrix == null || matrix.length == 0) {
            return maxArea;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        Dimension[][] dimensions = new Dimension[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                dimensions[i][j] = new Dimension();
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == '1') {
                    dimensions[i][j].length = dimensions[i][j].height = 1;
                    if (i >= 1) {
                        dimensions[i][j].length += dimensions[i - 1][j].length;
                    }
                    if (j >= 1) {
                        dimensions[i][j].height += dimensions[i][j - 1].height;
                    }
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == '1') {
                    dimensions[i][j].length = dimensions[i][j].height = 1;
                    if (i >= 1) {
                        dimensions[i][j].length += dimensions[i - 1][j].length;
                    }
                    if (j >= 1) {
                        dimensions[i][j].height += dimensions[i][j - 1].height;
                    }
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                int heightToGo = dimensions[i][j].height;
                int currJ = j;
                int currLength = dimensions[i][j].length;

                currJ--;

                while (currJ >= 0 && heightToGo >= 2) {
                    currLength = Math.min(currLength, dimensions[i][currJ].length);
                    if (currLength == 0) {
                        break;
                    }
                    currJ--;
                    heightToGo--;
                }

                maxArea = Math.max(maxArea, currLength * dimensions[i][j].height);

            }
        }

        return maxArea;
    }
}