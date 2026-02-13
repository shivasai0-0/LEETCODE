class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int j;
                for(j=i-1;j>-1;j--){
                    if(nums[j]>i-j){
                        break;
                    }
                    else if(nums[j]==i-j&&i==nums.length-1) return true;
                }
                if(j==-1) return false;
            }
        }
        return true;
    }
}