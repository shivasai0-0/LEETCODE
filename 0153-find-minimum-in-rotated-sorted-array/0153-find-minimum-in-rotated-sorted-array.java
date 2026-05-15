
class Solution {
    public int findMin(int[] nums) {
        return nums[solve(nums,nums.length)];
    }
    public int solve(int[] nums,int n){
        int low=0;
        int high=n-1;
        while(low <high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }

}