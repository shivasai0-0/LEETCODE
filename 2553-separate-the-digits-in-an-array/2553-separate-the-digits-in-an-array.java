class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer> list= new LinkedList<>();
        for(int i=0;i<n;i++){
            int x=nums[i];
            String s=Integer.toString(x);
            for(char ch:s.toCharArray()){
                list.add(ch-'0');

            }

        }
        int[] ans = list.stream().mapToInt(i -> i).toArray();

        return ans;
    }
}