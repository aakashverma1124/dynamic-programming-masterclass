import math
def solve(n, dp) :
    if n <= 2 :
        return 1
    
    if  dp[n] != -1:
        return dp[n]
    
    maxProduct = -math.inf
    for i in range(1, n):
        product = max(i * solve(n - i, dp), i * (n - i))
        maxProduct =  max(product, maxProduct)
    
    dp[n] = maxProduct
    return dp[n]

def integerBreak(n):
    dp = [-1] * (n + 1)
    return solve(n, dp)
