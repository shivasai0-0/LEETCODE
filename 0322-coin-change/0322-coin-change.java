class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF=(int)1e9;
        int n=coins.length;
        int s=amount;
        int[][] dp = new int[n+1][s+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<s+1;i++){
            dp[0][i]=INF;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        int x=dp[n][s];

        return (x<INF)?x:-1;
    }
}