Important Questions

### Best time to buy and sell with K transactions

Treat it as a DP problem where the rows represent number of transactions and the columns represent the prices on the days.

`int[][] dp = new int[k + 1][prices.length]`

- Iterate K from 1 to k
- Have a `maxDiff` which is equal to `-prices[0]`
- Iterate `j` from 1 to `len - 1`
    - `dp[i][j]` Max between the previous day, or `maxDiff` + `price[j]`
    - `maxDiff` Max between dp value for 1 less transaction - current day price `dp[i-1][j] - prices[j]` or `maxDiff`
- Return the last value in the dp array

### Best time to buy and sell stock with Cooldown

Treat is as DP problem with three arrays, which each represent the action of buying, holding and selling respectively.

- Initialize `buy[0]` as `-prices[0]` (Because we bought something and paid money)
- Iterate from 1 to `len - 1`
    - `hold[i]` is the max between holding the previous day and selling the previous day
    - `hold[i] = max(hold[i-1], sell[i-1])`
    - `buy[i]` is the max between buying the previous day and what is left after holding the previous day and buying today
    - `buy[i] = max(buy[i-1], sell[i-1] + prices[i])`
    - `sell[i]` is the sum of buying the previous day, and the price of stocks today
    - `sell[i] = buy[i-1] + prices[i]`
- Return the maximum value between holding on the last day and selling on the last day