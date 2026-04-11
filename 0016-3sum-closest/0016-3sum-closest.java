class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int minabs=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(minabs>Math.abs(sum-target)){
                    minabs=Math.abs(sum-target);
                    ans=sum;
                }
                if(sum>target){
                    right--;
                }
                else if(sum<=target){
                    left++;
                }
            }
        }
        return ans;
    }
}