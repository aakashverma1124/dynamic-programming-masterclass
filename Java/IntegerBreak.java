import java.util.*;

class Solution {
    private int solve(int n, int[] dp) {
        if(n <= 2) return 1;
        
        if(dp[n] != -1) return dp[n];
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            int product = Math.max(i * solve(n - i, dp), i * (n - i)) ;
            maxProduct = Math.max(product, maxProduct);
        }
        return dp[n] = maxProduct;
    }
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}