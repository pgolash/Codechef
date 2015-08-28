package LeetCode.Arrays;

/**
 * Created by pgolash on 8/28/2015.
 */
public class BuyAndSellStockIII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] minToLeft = new int[prices.length];
        int[] maxToRight = new int[prices.length];
        int maxGain = 0;

        int globalMinimum = prices[0];
        int globalMaximum = prices[prices.length - 1];

        minToLeft[0] = prices[0];
        maxToRight[prices.length - 1] = prices[prices.length - 1];

        for (int i = 1; i <= prices.length - 1; i++) {
            if (globalMinimum > prices[i]) {
                globalMinimum = prices[i];
            }
            minToLeft[i] = globalMinimum;
        }

        for (int i = prices.length - 2; i >= 0; i--) {
            if (globalMaximum < prices[i]) {
                globalMaximum = prices[i];
            }
            maxToRight[i] = globalMaximum;
        }

        int maxProfitInLeft = 0;

        for (int i = 0; i < prices.length; i++) {
            maxGain = Math.max(maxGain, maxProfitInLeft + (maxToRight[i] - prices[i]));
            maxProfitInLeft = Math.max(maxProfitInLeft, prices[i] - minToLeft[i]);
        }

        maxGain = Math.max(maxGain, maxProfitInLeft);
        return maxGain;
    }

    public static void main(String[] args) {
        new BuyAndSellStockIII().maxProfit(new int[]{1, 2});
    }

}
