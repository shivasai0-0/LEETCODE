class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] visited=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(isConnected,visited,n,i);
            }
        }
        return count;   
    }
    private void dfs(int[][] isConnected, int[] visited,int n,int x){
        for(int i=0;i<n;i++){
            if(isConnected[x][i]==1&&visited[i]==0){
                visited[i]=1;
                dfs(isConnected,visited,n,i);
            }
        }   
    }
}