class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        while(j<nums.length){
            if(map.containsKey(nums[j])){
                int r=map.get(nums[j]);
                if(Math.abs(j-r)<=k){ return true;}
            }
            map.put(nums[j],j);
            j++;

        }
        return false;
        
    }
}