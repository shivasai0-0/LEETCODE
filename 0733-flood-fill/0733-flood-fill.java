class point{
    int row;
    int col;
    point(int a,int b){
        this.row=a;
        this.col=b;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row= image.length;
        int col= image[0].length;
        int oldC=image[sr][sc];
        int[][] copy= new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                copy[i][j]=image[i][j];
            }
        }
        int[][] visited=new int[row][col];
        visited[sr][sc]=1;
        copy[sr][sc]=color;
        dfs(copy,visited,row,col,new point(sr,sc),oldC,color);
        return copy;


    }
    private void dfs(int[][] copy, int[][] visited,int row , int col , point p, int oldC, int color){
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=p.row+drow[i];
            int nc=p.col+dcol[i];
            if(nr>=0&&nr<row&&nc>=0&&nc<col&&visited[nr][nc]==0&&copy[nr][nc]==oldC){
                copy[nr][nc]=color;
                visited[nr][nc]=1;
                dfs(copy,visited,row,col,new point(nr,nc),oldC,color);

            }
        }   
    }
}