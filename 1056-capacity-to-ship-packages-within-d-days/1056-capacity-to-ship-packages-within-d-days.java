class Solution {
    private boolean cal(int[] weights, int days, int x) {
        int count = 0;
        int neededDays = 1;
        for (int w : weights) {
            if (w > x) return false;
            if (count + w > x) {              
                neededDays++;
                count = 0;
            }
            count += w;
        }
        return neededDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(cal(weights,days,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}