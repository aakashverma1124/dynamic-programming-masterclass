import java.util.*;

class Solution {
    public int solve(int row, int col, int[][] matrix, int[][] dp) {

        if(row == matrix.length - 1) 
            return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int min = Integer.MAX_VALUE;
        for(int c = 0; c < matrix[0].length; c++) {
            if(c == col) continue;
            min = Math.min(min, matrix[row][col] + solve(row + 1, c, matrix, dp));
        }

        dp[row][col] = min;
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