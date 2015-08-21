package LeetCode.Arrays;

/**
 * Created by prashantgolash on 8/19/15.
 */
public class BuySellStockII {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int currIdx = 0;
        boolean isComplete = false;

        while (!isComplete) {
            int saveIdx = currIdx;

            while (currIdx + 1 < prices.length && prices[currIdx] < prices[currIdx + 1]) {
                currIdx++;
            }

            maxProfit += prices[currIdx] - prices[saveIdx];
            currIdx++;

            if (currIdx >= prices.length) {
                isComplete = true;
            }
        }

        return maxProfit;

    }
}
