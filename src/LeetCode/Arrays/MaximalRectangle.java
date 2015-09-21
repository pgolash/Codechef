package LeetCode.Arrays;

/**
 * Created by pgolash on 9/16/2015.
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] myChar = new char[1][2];
        myChar[0] = new char[] {'1', '0'};
        new MaximalRectangle().maximalRectangle(myChar);

    }

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
                    if (j >= 1) {
                        dimensions[i][j].length += dimensions[i][j - 1].length;
                    }
                    if (i >= 1) {
                        dimensions[i][j].height += dimensions[i - 1][j].height;
                    }
                }
            }
        }

        for (int j = 0; j < colLength; j++) {
            for (int i = 0; i < rowLength; i++) {

                int heightToGo = dimensions[i][j].height;
                int currI = i;
                int currLength = dimensions[i][j].length;

                maxArea = Math.max(maxArea, currLength);

                currI--;

                while (currI >= 0 && heightToGo >= 2) {
                    currLength = Math.min(currLength, dimensions[currI][j].length);
                    if (currLength == 0) {
                        break;
                    }
                    maxArea = Math.max(maxArea, currLength * (i - currI + 1));
                    currI--;
                    heightToGo--;
                }
            }
        }

        return maxArea;
    }
}