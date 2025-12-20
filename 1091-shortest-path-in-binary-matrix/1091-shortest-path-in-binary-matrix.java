class point{
    int row,col,dist;
    point(int a , int b, int c){
        this.row=a;
        this.col=b;
        this.dist=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(n==1){ return grid[0][0]==0?1:-1;}
        if(grid[0][0]==1|| grid[n-1][n-1]==1){ return -1;}
        int[][] dist= new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        point src= new point(0,0,1);
        dist[src.row][src.col]=src.dist;
        PriorityQueue<point> pq= new PriorityQueue<>(
            (a,b)->a.dist-b.dist
        );
        pq.offer(src);
        return method(grid,dist,n,pq);
  
    }
    private int method(int[][] grid , int[][] dist,int n,PriorityQueue<point> pq){
        int[] drow={-1,-1,-1,0,1,1,1,0};
        int[] dcol={-1,0,1,1,1,0,-1,-1};
        while(!pq.isEmpty()){
            point p=pq.poll();
            if(p.dist>dist[p.row][p.col]) continue ;
            for(int i=0;i<8;i++){
                int nr=p.row+drow[i];
                int nc=p.col+dcol[i];
                int ndist=p.dist+1;
                if(nr<0||nr>=n||nc<0||nc>=n||grid[nr][nc]==1){
                    continue;
                }
                if(nr==n-1&&nc==n-1){
                    return ndist;
                    }
                if (ndist < dist[nr][nc]) {
                    dist[nr][nc] = ndist;
                    pq.offer(new point(nr, nc, ndist));
                }

            }

        }
        return -1;

    }
}