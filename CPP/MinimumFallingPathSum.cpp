class Solution {
public:

    int solve(int row, int col, vector<vector<int>>& grid, vector<vector<int>>& dp) {
        if(col < 0 || col >= grid.size()) 
            return 10000;

        if(row == grid.size() - 1) 
            return grid[row][col];

        if(dp[row][col] != -1) 
            return dp[row][col];
        
        int ans1 = grid[row][col] + solve(row + 1, col - 1, grid, dp);
        int ans2 = grid[row][col] + solve(row + 1, col, grid, dp);
        int ans3 = grid[row][col] + solve(row + 1, col + 1, grid, dp);
        
        return dp[row][col] = min(ans1, min(ans2, ans3));
    }

    int minFallingPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int minimumSum = INT_MAX;
        vector<vector<int>> dp(n, vector<int>(n, -1));

        for(int i = 0; i < n; i++) {
            minimumSum = min(minimumSum, solve(0, i, grid, dp));
        }
        return minimumSum;
        
    }
};