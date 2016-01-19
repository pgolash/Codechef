package LeetCode.Permutations;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence seq = new PermutationSequence();
        System.out.println(seq.getPermutation(3, 1));
    }

    public String getPermutation(int n, int k) {
        if (n == 1 || n == 0) {
            if (n == 1) {
                return "1";
            } else {
                return "0";
            }
        } else {
            StringBuilder bld = new StringBuilder();
            int cnt = n - 1;
            boolean[] filledNumber = new boolean[n + 1];
            Arrays.fill(filledNumber, false);

            int[] fact = new int[n + 1];
            fact[0] = fact[1] = 1;

            for (int i = 2; i <= n; i++) {
                fact[i] = fact[i - 1] * i;
            }

            while (cnt >= 0) {
                int number;

                if (k != 1) {
                    number = (k - 1) / fact[cnt] + 1;
                } else {
                    number = k;
                }

                bld.append(getNumber(number, filledNumber));

                if (k % fact[cnt] == 0) {
                    k = k - (k / fact[cnt] - 1) * fact[cnt];
                } else {
                    k = k - (k / fact[cnt]) * fact[cnt];
                }

                cnt--;
            }

            return bld.toString();

        }
    }

    public int getNumber(int searchNumber, boolean[] filledNumber) {
        int cnt = 0;
        int idx = 1;

        while (cnt < searchNumber ) {
            if (!filledNumber[idx]) {
                cnt++;
            }
            idx++;
        }

        idx--;
        filledNumber[idx] = true;
        return idx;
    }
}
