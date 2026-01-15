class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){ return 0;}
        int[][] t= new int[m][n];
        for(int[] i:t){
            Arrays.fill(i,-1);
        }
        return solve(0,0,m,n,t,obstacleGrid);


        
    }
    public int solve(int i , int j,int m , int n, int[][] dp , int[][] map){
        if(i==m-1&&j==n-1){ return 1;}
        if(i>=m||j>=n||map[i][j]==1){ return 0;}
        if(dp[i][j]!=-1){ return dp[i][j];}
        dp[i][j]=solve(i,j+1,m,n,dp,map)+solve(i+1,j,m,n,dp,map);
        return dp[i][j];
    }
}