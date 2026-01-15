class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] t= new int[m][n];
        for(int[] i:t){
            Arrays.fill(i,-1);
        }
        return solve(0,0,m,n,t,grid);
        
    }
    public int solve(int i , int j,int m , int n, int[][] dp,int[][] grid ){
        if(i==m-1&&j==n-1){ return grid[i][j] ;}
        if(i>=m||j>=n){ return Integer.MAX_VALUE;}
        if(dp[i][j]!=-1){ return dp[i][j];}
        int bottom=solve(i+1,j,m,n,dp,grid);
        int right=solve(i,j+1,m,n,dp,grid);
        dp[i][j]=grid[i][j]+Math.min(right,bottom);
        return dp[i][j];
    }
}