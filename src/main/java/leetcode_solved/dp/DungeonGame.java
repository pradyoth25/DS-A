package leetcode_solved.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        // corner case
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }

        // dp[i][j] represents the health when I reach dungeon[i][j]
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // initialization:
        // dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        // or dp[m - 1][n - 1] = dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
        // induction rule:
        // dp[i][n - 1] = max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1)
        // dp[m - 1][j] = max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1)
        // dp[i][j] = min(max(dp[i][j + 1] - dungeon[i][j], 1), max(dp[i + 1][j] - dungeon[i][j], 1))
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }else if(i == m - 1){
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                }else if(j == n - 1){
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                }else{
                    dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1), Math.max(dp[i][j + 1] - dungeon[i][j], 1));
                }
            }
        }
        return dp[0][0];
    }

}
