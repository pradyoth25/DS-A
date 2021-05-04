package problem_types;

public class LongestCommonSubarray {

    public int longestCommonSubArray(String[] s1, String[] s2) {
        int m = s1.length, n = s2.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1[i].equals(s2[j])) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

}
