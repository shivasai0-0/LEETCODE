class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum=0;
        for(int i:stones){
            totalSum+=i;
        }
        int n=stones.length;
        boolean [][] dp= new boolean[n+1][totalSum+1];
        for(int i=0;i<n+1;i++){ dp[i][0]=true;}
        for(int i=1;i<totalSum+1;i++){ dp[0][i]=false;}
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totalSum+1;j++){
                if(stones[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j-stones[i-1]]||dp[i-1][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        if(totalSum%2==0&&dp[n][totalSum/2]){
            return 0;
        }
        for(int i=0;i<(totalSum+1)/2;i++){
            if(dp[n][i]){
                min=Math.min(min,totalSum-2*i);
            }
        }
        return min;
    }
}