class point{
    int row,col,eff;
    point(int a , int b, int c){
        this.row=a;
        this.col=b;
        this.eff=c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] grid=heights;
        int row=heights.length;
        int col=heights[0].length;
        if(row==1&&col==1){ return 0;}
        int[][] dist= new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        point src= new point(0,0,0);
        dist[src.row][src.col]=src.eff;
        PriorityQueue<point> pq= new PriorityQueue<>(
            (a,b)->a.eff-b.eff
        );
        pq.offer(src);
        method(grid,dist,row,col,pq);
        return dist[row-1][col-1];
  
    }
    private void method(int[][] grid , int[][] dist,int row,int col,PriorityQueue<point> pq){
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int maxeff=0;
        while(!pq.isEmpty()){
            point p=pq.poll();
            if(p.eff>dist[p.row][p.col]) continue;
            for(int i=0;i<4;i++){
                int nr=p.row+drow[i];
                int nc=p.col+dcol[i];
                if(nr<0||nr>=row||nc<0||nc>=col){
                    continue;
                }
                int neff=Math.max(Math.abs(grid[nr][nc]-grid[p.row][p.col]),p.eff);
                if(neff<dist[nr][nc]){
                    dist[nr][nc]=neff;
                    pq.offer(new point(nr,nc,neff));
                }


            }

        }

    }
}