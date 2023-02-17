class Solution {
public:

    int solve(int row, int col, vector<vector<int>>& grid, vector<vector<int>>& dp) {
        if(row == grid.size() - 1) return grid[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int minimumSum = INT_MAX;
        for(int c = 0; c < grid[0].size(); c++) {
            if(c != col) {
                minimumSum = min(minimumSum, grid[row][col] + solve(row + 1, c, grid, dp));
            }
        }
        return dp[row][col] = minimumSum;
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