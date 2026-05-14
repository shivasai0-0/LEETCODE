class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=nums[n-1];
        if(max+1==n&&nums[n-1]==nums[n-2]){
            for(int i=1;i<n;i++){
                if(nums[i-1]!=i){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}