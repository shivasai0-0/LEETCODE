class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){ return nums[0];}
        return Math.max(solve(Arrays.copyOfRange(nums,0,nums.length-1)),
        solve(Arrays.copyOfRange(nums,1,nums.length)));
        
    }
    public int solve (int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+2];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n+1;i++){
            dp[i]=Math.max(nums[i-2]+dp[i-2],dp[i-1]);
        }
        return dp[n+1];
    }
}