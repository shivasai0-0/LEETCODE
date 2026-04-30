class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set= new HashSet<>();
        Set<Integer> result= new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                result.add(i);
            }
        }
        int[] arr=new int[result.size()];
        int index=0;
        for(int i:result){
            arr[index++]=i;
        }
        return arr;

        
    }
}