class Solution {
    public int integerBreak(int n) {
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=n;j++){
                if(i>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],i*dp[i][j-i]);
                }
            }
        }
        return dp[n-1][n];
    }
}