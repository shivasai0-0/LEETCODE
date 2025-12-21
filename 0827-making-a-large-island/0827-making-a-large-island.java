class disjoint{
    public int[] size;
    public int[] parent;
    disjoint(int n){
        size= new int[n];
        parent= new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Arrays.fill(size,1);
    }
    int findparent(int i){
        if(parent[i]==i){
            return i;
        }
        parent[i]=findparent(parent[i]);
        return parent[i];
    }
    void union(int u , int v){
        int pu=findparent(u);
        int pv=findparent(v);
        if(pu==pv) return;
        else if( size[pu]>size[pv]){
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        else{
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        boolean haszero=false;
        int[] drows={-1,0,1,0};
        int[] dcols={0,1,0,-1};
        disjoint dj=new disjoint(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+drows[k];
                        int nc=j+dcols[k];
                        if(isvalid(nr,nc,n)&&grid[nr][nc]==1){
                            dj.union(nr*n+nc,i*n+j);
                        }

                    }
                }
                else{
                    haszero=true;
                }
            }
        }
        HashSet<Integer> set= new HashSet<>();
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    for(int k=0;k<4;k++){
                        int nr=i+drows[k];
                        int nc=j+dcols[k];
                        if(isvalid(nr,nc,n)&&grid[nr][nc]==1){
                            int pn=dj.findparent(nr*n+nc);
                            set.add(pn);

                        }

                    }
                    int sum=0;
                    for(int r:set){
                        sum+=dj.size[r];
                    }
                    sum++;
                    max=Math.max(sum,max);
                    set.clear();
                }
            }
        }
        return haszero?max:n*n;
        
    }
    private boolean isvalid(int r, int c, int n){
        return !(r<0||r>=n||c<0||c>=n);
    }
}