package LeetCode.Arrays;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class BestTimeToBuyAndSellStockCoolDown {

    public static void main(String[] args) {
        int[] prices = new int[] {1, 2, 3, 0, 2};
        System.out.println(new BestTimeToBuyAndSellStockCoolDown().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0);
    }

    public int maxProfit(int[] prices, int start) {
        if (start == prices.length - 1) {
            return 0;
        } else {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[i] > prices[start]) {
                    maxProfit = Math.max((prices[i] - prices[start]) + maxProfit(prices, i + 2), maxProfit);
                }
            }
            return maxProfit;
        }
    }
}

