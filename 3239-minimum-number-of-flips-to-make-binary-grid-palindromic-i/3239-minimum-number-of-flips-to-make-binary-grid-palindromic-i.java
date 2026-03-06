class Solution {
    public int minFlips(int[][] grid) {
        int rowmin=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                if(grid[i][j]!=grid[i][col-j-1]){
                    rowmin++;
                }
            }
        }
        int colmin=0;
        for(int j=0;j<col;j++){
            for(int i=0;i<row/2;i++){
                if(grid[i][j]!=grid[row-i-1][j]){
                    colmin++;
                }
            }
        }
        return Math.min(rowmin,colmin);
    }
}