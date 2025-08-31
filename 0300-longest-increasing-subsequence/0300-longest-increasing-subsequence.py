class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n=len(nums)
        rr=[[-1]*(n+1) for _ in range(n)]
        def dp(i,prev):
            if i==n: return 0
            if rr[i][prev+1]!=-1: return rr[i][prev+1]
            not_take=dp(i+1,prev)
            take=0
            if prev==-1 or nums[i]>nums[prev]:
                take=1+dp(i+1,i)
            rr[i][prev+1]=max(not_take,take)
            return rr[i][prev+1]
        return dp(0,-1)       