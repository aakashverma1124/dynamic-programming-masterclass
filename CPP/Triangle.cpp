class Solution {
public:
    int solve(int row, int col, vector<vector<int>>& triangle, vector<vector<int>>& dp) {

        if(col >= triangle[row].size()) return INT_MAX;

        if(row == triangle.size() - 1) return triangle[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int left = triangle[row][col] + solve(row + 1, col, triangle, dp);
        int right = triangle[row][col] + solve(row + 1, col + 1, triangle, dp);
        return dp[row][col] = min(left, right);
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        vector<vector<int>> dp;
        for(int i = 0; i < triangle.size(); i++) {
            vector<int> d(triangle[i].size(), -1);
            dp.push_back(d);
        }
        return solve(0, 0, triangle, dp);
    }
};

