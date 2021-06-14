package leetcode_solved.karat;

import java.util.*;

public class DomainVisits {

    public List<String> domainVisits2Dp(String[] visit1, String[] visit2) {
        int m = visit1.length, n = visit2.length;
        int[][] dp = new int[m + 1][n + 1];
        int left = 0, max = 0;
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (visit1[i - 1].equals(visit2[j - 1])) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        left = i - dp[i][j];
                    }
                }
            }
        }
        System.out.println(left + " and " + dp[m][n]);
        List<String> res = new ArrayList<String>(Arrays.asList(visit1));
        return res.subList(left, dp[m][n] + 1);
    }

    // O(Min(M, N) * Log(min(M, N)) * (M + N))
    public List<String> domainVisits2(String[] visit1, String[] visit2) {
        int len = Math.min(visit1.length, visit2.length);
        int l = 0, r = len + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (helper(visit1, visit2, mid).size() != 0) l = mid + 1;
            else r = mid;
        }
        return helper(visit1, visit2, l - 1);
    }

    private List<String> helper(String[] visit1, String[] visit2, int len) {
        List<String> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < visit1.length - len + 1; i ++) {
            seen.add(Arrays.toString(Arrays.copyOfRange(visit1, i, i + len)));
        }
        for (int j = 0; j < visit2.length - len + 1; j ++) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(visit2, j, j + len)))) {
                Collections.addAll(res, Arrays.copyOfRange(visit2, j, j + len));
            }
        }
        return res;
    }

}
