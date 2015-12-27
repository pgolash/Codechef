package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 18/12/15.
 */
public class MaxProductExcept {
    public void arrayMultiplication(int A[], int OUTPUT[], int n) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < n; i++)
            OUTPUT[i] = 1;
        for (int i = 0; i < n; i++) {
            OUTPUT[i] *= left;
            OUTPUT[n - 1 - i] *= right;
            left *= A[i];
            right *= A[n - 1 - i];
        }
    }
}
