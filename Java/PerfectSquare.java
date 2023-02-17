import java.util.*;

class Solution {

    public int solve(int n, int[] dp) {
        if(n <= 0) return 0;

        if(dp[n] != -1) return dp[n];

        int minPerfectSquares = Integer.MAX_VALUE;
        for(int i = 1; i <= (int)Math.sqrt(n); i++) {
            int ans = 1 + solve(n - (i * i), dp);
            minPerfectSquares = Math.min(minPerfectSquares, ans);
        }
        
        return dp[n] = minPerfectSquares;
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}