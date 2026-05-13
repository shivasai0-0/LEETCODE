class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year= new int[102];
        Arrays.fill(year,0);
        int n=logs.length;
        for(int i=0;i<n;i++){
            year[logs[i][0]-1950]+=1;
            year[logs[i][1]-1950]-=1;
        }
        int max=Integer.MIN_VALUE;
        int idx=-1;
        int sum=0;
        for(int i=0;i<101;i++){
            sum+=year[i];
            if(sum>max){
                idx=i;
                max=sum;
            }
        }
        return 1950+idx;
    }
}