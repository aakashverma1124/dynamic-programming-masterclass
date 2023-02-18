import math
def solve(row, col, triangle, dp): 

    if col > len(triangle[row]) :
        return math.inf
    if row == len(triangle) -1 :
        return triangle[row][col]
    
    if dp[row][col] != -1 :
        return triangle[row][col]
    
    left = triangle[row][col] + solve(row + 1, col, triangle, dp)
    right = triangle[row][col] + solve(row + 1, col + 1, triangle, dp)

    dp[row][col] = min(left, right)

    return dp[row][col]

def minimumTotal(triangle) :
    dp = [[-1]*len(triangle[0]) for _ in range(len(triangle))]
    return solve(0, 0, triangle, dp)