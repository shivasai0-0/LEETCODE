class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int end=landStartTime[i]+landDuration[i];
            for(int j=0;j<m;j++){
                int startSecond = Math.max(end, waterStartTime[j]);
                min=Math.min(min,startSecond+waterDuration[j]);
            }
        }
        for(int i=0;i<m;i++){
            int end=waterStartTime[i]+waterDuration[i];
            for(int j=0;j<n;j++){
                int startSecond = Math.max(end, landStartTime[j]);
                min=Math.min(min,startSecond+landDuration[j]);
            }
        }
        return min;


        
    }
}