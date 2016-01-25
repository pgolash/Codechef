package LeetCode.CombinationSum;

import java.util.Arrays;

/**
 * Created by prashantgolash on 21/01/16.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        } else {
            int[] DP = new int[amount + 1];
            Arrays.sort(coins);
            Arrays.fill(DP, Integer.MAX_VALUE);
            DP[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i < coins[j]) {
                        break;
                    } else {
                        if (DP[i - coins[j]] != Integer.MAX_VALUE) {
                            DP[i] = Math.min(DP[i], DP[i - coins[j]] + 1);
                        }
                    }
                }

            }
            return DP[amount] == Integer.MAX_VALUE ? -1 : DP[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[] {2};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }
}
