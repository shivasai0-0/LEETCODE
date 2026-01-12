class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalsum=0;
        for(int i:nums){ totalsum+=i;}
        if (Math.abs(target) > totalsum) return 0;
        if ((totalsum + target) % 2 != 0) return 0;
        int s1=(totalsum+target)/2;
        int dp[][]=new int[n+1][s1+1];
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<s1+1;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[n][s1];
        
    }
}