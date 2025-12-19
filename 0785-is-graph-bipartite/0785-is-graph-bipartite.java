class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] visited= new int[V];
        HashMap<Integer,Integer> map=new HashMap<>();
        int bin=0;
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(!dfs(graph,visited,i,map,bin)){
                    return false;
                }
            }

        }
        return true; 
    }
    private boolean dfs(int[][] graph , int[] visited , int v,HashMap<Integer,Integer> map,int bin ){
        visited[v]=1;
        map.put(v,bin);
        for(int i:graph[v]){
            if(visited[i]==0){
                int y=1-bin;
                if(!dfs(graph,visited,i,map,y)){
                    return false;
                }
            }
            else if(map.containsKey(i)){
                int x=map.get(i);
                if(x==bin){
                    return false;
                }
            }
        }
        return true;
        
    }
}