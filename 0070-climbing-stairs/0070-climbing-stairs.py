class Solution:
    def climbStairs(self, n: int) -> int:
        dp={}
        prev2,prev1=0,1
        for i in range(1,n+1):
            dp[i]=prev2+prev1
            prev2=prev1
            prev1=dp[i]
        return dp[n]