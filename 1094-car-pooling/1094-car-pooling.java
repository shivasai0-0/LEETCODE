class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        int[] loc= new int[1001];
        Arrays.fill(loc,0);
        for(int i=0;i<n;i++){
            loc[trips[i][1]]+=trips[i][0];
            loc[trips[i][2]]-=trips[i][0];
        }
        int sum=0;
        boolean complete=true;
        for(int i:loc){
            sum+=i;
            if(sum>capacity){
                complete=false;
                break;
            }
        }
        return complete;
    }
}