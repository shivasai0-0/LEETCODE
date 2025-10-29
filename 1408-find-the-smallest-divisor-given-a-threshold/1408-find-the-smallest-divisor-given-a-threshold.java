class Solution {
    private int cal(int[] nums, int x){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=((nums[i]+x-1)/x);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(cal(nums,mid)<=threshold){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}