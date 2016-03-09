package LeetCode.Arrays;

/**
 * Created by prashantgolash on 26/01/16.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = 0;
        int sum = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > max) {
                max = A[i - 1];
            }
            maxLeft[i] = max;
        }

        max = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] > max) {
                max = A[i + 1];
            }
            maxRight[i] = max;
        }

        for (int i = 0; i < A.length; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
}
