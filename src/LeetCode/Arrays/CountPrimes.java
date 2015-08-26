package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashant on 8/25/2015.
 */
public class CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return 0;
        } else {

            n = n - 1;

            boolean[] primes = new boolean[n + 1];
            Arrays.fill(primes, true);

            primes[1] = false;
            primes[2] = true;

            int cntPrime = 0;

            for (int i = 1; i <= n / 2; i++) {
                if (primes[i]) {
                    for (int k = 2 * i; k <= n; k += i) {
                        primes[k] = false;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (primes[i]) {
                    cntPrime++;
                }
            }
            return cntPrime;
        }

    }
}
