import math
def solve(n, dp) :
    if n <= 0 :
        return 0

    if dp[n] != -1 :
        return dp[n]

    minPerfectSquares = math.inf
    for i in range(1, int(math.sqrt(n)) + 1):
        ans = 1 + solve(n - (i * i), dp) 
        minPerfectSquares = min(minPerfectSquares, ans)
    
    dp[n] = minPerfectSquares
    
    return dp[n]

def numSquares(n) :
    dp = [-1] * (n+1)
    return solve(n, dp)