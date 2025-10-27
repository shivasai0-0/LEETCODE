class Solution {
    private void reverse(int[] a, int left ,int  right){
        while(left<right){
            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        reverse(nums,i+1,nums.length-1);
    }
}
