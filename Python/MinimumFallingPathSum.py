import math

def solve(row, col, matrix, dp) :
    if col < 0 or col >= len(matrix[0]) :
        return 100000

    if row == len(matrix) - 1 :
        return matrix[row][col]
    
    if dp[row][col] != -1 :
        return dp[row][col]

    ans1 = matrix[row][col] + solve(row + 1, col - 1, matrix, dp)
    ans2 = matrix[row][col] + solve(row + 1, col, matrix, dp)
    ans3 = matrix[row][col] + solve(row + 1, col + 1, matrix, dp)

    dp[row][col] = min(ans1, ans2, ans3)

    return dp[row][col]

def minFallingPathSum(matrix) :
    n = len(matrix)

    minimumSum = math.inf
    dp = [[-1]*(n) for _ in range(n)]
    for col in range(n):
        currentSum = solve(0, col, matrix, dp)
        minimumSum = min(minimumSum, currentSum)
    
    return minimumSum