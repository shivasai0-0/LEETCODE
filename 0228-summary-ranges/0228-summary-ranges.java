class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<String> list= new ArrayList<>();
        int l=0;
        int r=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[r]+1){
                if(l==r){
                    list.add(Integer.toString(nums[l]));
                }
                else{
                    list.add(Integer.toString(nums[l])+"->"+Integer.toString(nums[r]));
                }
                l=i;
                r=i;
                continue;
            }
            r++;
        }
        if (l == r) {
            list.add(Integer.toString(nums[l]));
        } else {
            list.add(nums[l] + "->" + nums[r]);
        }
        return list;
    }
}