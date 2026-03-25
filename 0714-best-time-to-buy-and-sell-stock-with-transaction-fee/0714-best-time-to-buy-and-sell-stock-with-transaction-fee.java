class Solution {
    public int maxProfit(int[] prices, int fee) {
        return solve(prices,fee);
    }
    public int solve(int[] prices, int fee){
        int n=prices.length;
        int[][] dp= new int[n+1][2];
        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    profit=Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
                }
                else{
                    profit=Math.max(dp[i+1][1]+prices[i]-fee,dp[i+1][0]);
                }
                dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }
}