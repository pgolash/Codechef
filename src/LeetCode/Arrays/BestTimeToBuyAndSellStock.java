package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        } else {
            int maxDiff = 0;
            int max = Integer.MIN_VALUE;
            int min = Math.min(prices[1], prices[0]);

            if (prices[1] > prices[0]) {
                maxDiff = prices[1] - prices[0];
            }

            for (int i = 2; i < prices.length; i++) {
                maxDiff = Math.max(maxDiff, prices[i] - min);

                if (prices[i] < min) {
                    min = prices[i];
                }
            }

            return maxDiff;
        }
    }
}
