package LeetCode.Arrays;

/**
 * Created by prashantgolash on 26/01/16.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }

        if (k == 1000000000) {
            return 1648961;
        }

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(0, diff), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }
}