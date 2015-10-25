package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder bld = new StringBuilder();
        boolean isDone = false;
        int cnt = n - 1;
        boolean[] filledNumber = new boolean[n];
        Arrays.fill(filledNumber, false);

        int[] fact = new int[n];
        fact[0] = fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int numToFound = -1;

        while (cnt >= 0) {
            int remainingNumber;

            if (k % fact[cnt] == 0) {
                numToFound = k / fact[cnt];
                remainingNumber = k - (k / fact[cnt] - 1) * fact[cnt];
            } else {
                numToFound = k /  fact[cnt] + 1;
                remainingNumber = k - (k / fact[cnt]) * fact[cnt];
            }

            bld.append(getNumber(remainingNumber, filledNumber));
            k = remainingNumber;
            cnt--;
        }

        return bld.toString();
    }

    public int getNumber(int remainingNumber, boolean[] filledNumber) {
        int cnt = 0;
        int idx = 0;

        while (cnt < remainingNumber) {
            if (!filledNumber[idx]) {
                cnt++;
            } else {
                idx++;
            }
        }

        filledNumber[idx] = true;

        return idx;
    }
}
