class Solution {
public:

    int solve(int n, vector<int>& dp) {
        if(n <= 2) return 1;

        if(dp[n] != -1) return dp[n];

        int maxProduct = INT_MIN;
        for(int i = 1; i < n; i++) {
            int product = max(i * solve(n - i, dp), i * (n - i));
            maxProduct = max(product, maxProduct);
        }
        return dp[n] = maxProduct;
    }
    int integerBreak(int n) {
        vector<int> dp(n + 1, -1);
        return solve(n, dp);
    }
};