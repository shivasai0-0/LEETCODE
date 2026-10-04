class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int sum=0;
        int duplicate=-1;
        for(int i:nums){
            if(set.contains(i)){
                duplicate=i;
            }
            set.add(i);
            sum+=i;
        }
        int n=nums.length;
        int real=(n*(n+1))/2+duplicate-sum;
        return new int[]{duplicate,real};
    }
}