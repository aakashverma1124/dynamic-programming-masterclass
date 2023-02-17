import java.util.*;

class Solution {

    public int solve(int row, int col, int[][] matrix, int[][] dp) {

        if(col < 0 || col >= matrix[0].length) 
            return 100000;

        if(row == matrix.length - 1) 
            return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int ans1 = matrix[row][col] + solve(row + 1, col - 1, matrix, dp);
        int ans2 = matrix[row][col] + solve(row + 1, col, matrix, dp);
        int ans3 = matrix[row][col] + solve(row + 1, col + 1, matrix, dp);

        dp[row][col] = Math.min(ans1, Math.min(ans2, ans3));
        return dp[row][col];

    }
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int minimumSum = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for(int d[] : dp) {
            Arrays.fill(d, -1);
        }

        for(int col = 0; col < n; col++) {
            int currentSum = solve(0, col, matrix, dp);
            minimumSum = Math.min(minimumSum, currentSum);
        }

        return minimumSum;
    }
}