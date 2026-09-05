class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] arr= new int[n];
        int temp=nums[0];
        for(int i=0;i<n;i++){
            if(temp<nums[i]){
                arr[i]=nums[i];
                temp=nums[i];
            }
            else{
                arr[i]=temp;
            }
        }
        temp=nums[n-1];
        for(int i=n-1;i>=0;i--){
            if(temp>nums[i]){
                arr[i]-=nums[i];
                temp=nums[i];
            }
            else{
                arr[i]-=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                return i;
            }
        }
        return -1;
        
    }
}