class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int k=Integer.MAX_VALUE;
        int[][] dp= new int[n][n];
        for(int[] i:dp){
            Arrays.fill(i,k);
        }
        int x=0;
        for(int j=0;j<n;j++){
            if((x=solve(0,j,n,dp,matrix))<k){
                k=x;
            }

        }
        return k;
        
    }
    public int solve(int i , int j, int n, int[][] dp , int[][] matrix){
        if(j<0||j>=n){ return Integer.MAX_VALUE;}
        if(i==n-1){ return matrix[i][j];}
        if(dp[i][j]!=Integer.MAX_VALUE){ return dp[i][j];}
        dp[i][j]=matrix[i][j]+Math.min(Math.min(solve(i+1,j-1,n,dp,matrix),solve(i+1,j,n,dp,matrix)),solve(i+1,j+1,n,dp,matrix));
        return dp[i][j];
    }
}