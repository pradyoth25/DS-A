package problem_types;

public class Stonks {

    /**
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
     * the future to sell that stock.
     */
    public int maxProfitOneTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * Find the maximum profit you can achieve. You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     */
    public int maxProfitMultipleTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) maxProfit += (prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    /**
     * Find the maximum profit you can achieve. You may complete at most k transactions.
     */
    public int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        return helper(prices, k);
    }

    private int helper(int[] prices, int k) {
        int[][] dp = new int[k + 1][prices.length];
        // rows: number of transactions
        // cols: max profit on each day
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    /**
     * Find the maximum profit you can achieve. You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
     * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
     */
    public int maxProfitWithOneDayCoolDown(int[] prices) {
        int n = prices.length;
        int[] hodl = new int[n];
        int[] buy = new int[n];
        int[] sell = new int[n];
        hodl[0] = 0;
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            hodl[i] = Math.max(hodl[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], hodl[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
        }
        return Math.max(hodl[n - 1], sell[n - 1]);
    }

    /**
     * Find the maximum profit you can achieve. You may complete as many transactions as you like,
     * but you need to pay the transaction fee for each transaction.
     */
    public int maxProfitWithTransactionFee(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

}
