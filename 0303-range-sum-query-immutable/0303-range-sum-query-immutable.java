class NumArray {
    int[] prefixsum;

    public NumArray(int[] nums) {
        int n=nums.length;
        this.prefixsum= new int[n+1];
        int sum=0;
        prefixsum[0]=0;
        for(int i=1;i<=n;i++){
            sum+=nums[i-1];
            prefixsum[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixsum[right+1]-prefixsum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */