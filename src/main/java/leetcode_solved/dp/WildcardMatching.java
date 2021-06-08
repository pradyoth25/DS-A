package leetcode_solved.dp;

public class WildcardMatching {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     *
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j ++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }



}
