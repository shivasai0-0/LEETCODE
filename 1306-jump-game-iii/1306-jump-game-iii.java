class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] dp= new boolean[n];
        int[] visited= new int[n];
        Arrays.fill(dp,false);
        Arrays.fill(visited,0);
        return solve(arr,arr.length,dp,visited,start);
    }
    public boolean solve(int[] arr,int n ,boolean[] dp ,int[] visited,int i){
        if(i<0||i>=n){
            return false;
        }
        if(visited[i]==1){
            return dp[i];
        }
        visited[i]=1;
        if(arr[i]==0){
            dp[i]=true;
            return true;
        }
        dp[i]=solve(arr,n,dp,visited,i-arr[i])||solve(arr,n,dp,visited,i+arr[i]);
        return dp[i];
    }
}