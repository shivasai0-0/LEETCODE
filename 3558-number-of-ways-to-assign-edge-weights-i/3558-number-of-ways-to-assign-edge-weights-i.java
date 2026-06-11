class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<Integer>[] adj= new ArrayList[n+1];
        int mod=1_000_000_007;
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] i:edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        int[] visited= new int[n+1];
        Arrays.fill(visited,0);
        visited[1]=1;
        int h=height(adj,visited,1);
        h--;
        long oddsums=1;
        long num=2;
        while(h>0){
            if((h&1)==1){
                oddsums=(oddsums*num)%mod;
            }
            num=(num*num)%mod;
            h>>=1;

        }
        return (int)oddsums;

    }
    public int height(List<Integer>[] adj,int[] visited ,int i){
        int maxh=0;
        for(int j:adj[i]){
            if(visited[j]==0){
                visited[j]=1;
                maxh=Math.max(maxh,height(adj,visited,j)+1);
            }
        }
        return maxh;
    }
}