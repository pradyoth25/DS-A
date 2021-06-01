package leetcode_solved.arrays;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i ++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j ++) {
                dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    public int maxProfitWithOneDayCooldown(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n], sell = new int[n], hold = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            hold[i] = Math.max(hold[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], hold[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
        }
        return Math.max(hold[n - 1], sell[n - 1]);
    }

}
