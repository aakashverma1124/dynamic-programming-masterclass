class Solution {
public:

    int solve(int n, vector<int>& dp) {

        if(n <= 0) return 0;

        if(dp[n] != -1) return dp[n];

        int minPerfectSquares = INT_MAX;
        for(int i = 1; i <= sqrt(n); i++) {
            minPerfectSquares = min(minPerfectSquares, 1 + solve(n - i * i, dp));
        }
        return dp[n] = minPerfectSquares;
    }

    int numSquares(int n) {
        vector<int> dp(n + 1, -1);
        return solve(n, dp);
    }
};