import math
def solve(row, col, matrix, dp) :

    if row == len(matrix) - 1 :
        return matrix[row][col]
    
    if dp[row][col] != -1 :
        return dp[row][col]
    
    minimum = math.inf
    for c in range(len(matrix[0])) :
        if c == col :
            continue
        minimum = min(minimum, matrix[row][col] + solve(row + 1, c, matrix, dp))
    
    dp[row][col] = minimum
    return dp[row][col]

def minFallingPathSum(matrix) :
    n = len(matrix)
    minimumSum = math.inf

    dp = [[-1] * n for _ in range(n)]
    
    for col in range(n):
        currentSum = solve(0, col, matrix, dp)
        minimumSum = min(minimumSum, currentSum)
    
    return minimumSum
