package LeetCode.Graphs;

import java.util.Arrays;

/**
 * Created by prashantgolash on 17/01/16.
 */
public class SmallestRectangle {

    private char[][] image;
    public int minArea(char[][] image, int x, int y) {

        int left = getLeftRightMost(image, y, true);
        int right = getLeftRightMost(image, y, false);

        int up = getUpBottomMost(image, x, true);
        int bottom = getUpBottomMost(image, x, false);

        return (right - left + 1) * (-up + bottom + 1);
    }

    private int getUpBottomMost(char[][] image, int x, boolean up) {
        int height = image.length;
        int width = image[0].length;
        int start = up ? 0 : x;
        int end = up ? x : height - 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean black = false;
            for (int i = 0; i < width; i++) {
                if (image[mid][i] == '1') {
                    black = true;
                    break;
                }
            }
            if (!black) {
                if (up) start = mid + 1;
                else {
                    end = mid - 1;
                }
            } else {
                res = mid;
                if (up) end = mid - 1;
                else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }

    private int getLeftRightMost(char[][] image, int y, boolean left) {
        int height = image.length;
        int width = image[0].length;
        int start = left ? 0 : y;
        int end = left ? y : width - 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean black = false;
            for (int i = 0; i < height; i++) {
                if (image[i][mid] == '1') {
                    black = true;
                    break;
                }
            }
            if (!black) {
                if (left) start = mid + 1;
                else end = mid - 1;
            } else {
                res = mid;
                if (left) end = mid - 1;
                else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }
}