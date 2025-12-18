class point{
    int row;
    int col;
    int t;
    point(int a , int b , int c){
        this.row=a;
        this.col=b;
        this.t=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int col=grid[0].length;
        int row=grid.length;
        int[][] visited= new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                visited[i][j]=0;
            }
        }
        int tmax=bfs(grid,visited,row,col);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]==0&&grid[i][j]==1){
                    return -1;
                }
            }
        }
        return tmax;
        
    }
    private int bfs(int[][] grid, int visited[][], int row, int col){
        Queue<point> q = new LinkedList<>();
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new point(i,j,0));
                    visited[i][j]=1;
                }
            }
        }
        int tmax=0;
        while(q.isEmpty()!=true){
            point p=q.remove();
            tmax=Math.max(tmax,p.t);
            for(int i=0;i<4;i++){
                int nr=p.row+drow[i];
                int nc=p.col+dcol[i];
                if(nr>=0&&nr<row&&nc>=0&&nc<col&& visited[nr][nc]==0&&grid[nr][nc]==1){
                    visited[nr][nc]=1;
                    q.add(new point(nr,nc,p.t+1));

                }
            }

        }
        return tmax;



    }
}