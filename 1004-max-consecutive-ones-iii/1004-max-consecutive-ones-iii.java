class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        int len=nums.length;
        int count=0;
        int max=0;
        while(r<len){
            if(nums[r]==0){
                count++;
            }
            if(count<=k){
                if(max<r-l+1){
                    max=r-l+1;
                }
            }
            while(count>k){
                if(nums[l]==0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return max;
    }
}