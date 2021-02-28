package algorithms.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    /**
     * GRID TRAVELER
     */

    public int naiveTravel(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        return naiveTravel(m - 1, n) + naiveTravel(m, n - 1);
    }

    public long realTravel(int m, int n) {
        return travelMemo(m, n, new HashMap<String, Long>());
    }

    private long travelMemo(int m, int n, Map<String, Long> memo) {
        if (m == 0 || n == 0) return Long.valueOf(0);
        if (m == 1 || n == 1) return Long.valueOf(1);
        String key = m > n ? n + "-" + m : m + "-" + n;
        if (memo.containsKey(key)) return memo.get(key);
        long value = travelMemo(m - 1, n, memo) + travelMemo(m, n - 1, memo);
        memo.put(key, value);
        return value;
    }

    public int gridTravellerDP(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i < m - 1) dp[i + 1][j] += dp[i][j];
                if (j < n - 1) dp[i][j + 1] += dp[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
