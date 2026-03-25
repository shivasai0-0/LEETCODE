class Solution {
    public int maxProfit(int[] prices) {
        return solve(prices);
    }
    public int solve(int[] prices){
        int n=prices.length;
        int[][] dp= new int[n+2][2];
        dp[n][0]=dp[n][1]=0;
        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==0){
                    profit=Math.max(dp[i+2][1]+prices[i],dp[i+1][0]);
                }
                else{
                    profit=Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
                }
                dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }
}