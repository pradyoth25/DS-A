package algorithms.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    /**
     * FIBONACCI
     *
     */

    public int fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacciMemo(int n) {
        if (n < 2) return n;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fibMemo(n, memo);
    }

    private int fibMemo(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public int fibonacciDP(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i ++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n - 1];
    }

}
