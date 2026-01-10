class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int i:nums){ totalsum+=i;}
        if(totalsum%2==1){ return false;}
        int halfsum=totalsum/2;
        boolean[][] dp= new boolean[n+1][halfsum+1];
        for(int i=1;i<halfsum+1;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<halfsum+1;j++){
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] 
                               || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][halfsum];
        
    }
}