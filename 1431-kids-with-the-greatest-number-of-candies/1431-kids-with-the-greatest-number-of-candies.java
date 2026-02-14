class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        List<Boolean> list= new ArrayList<>();
        for(int i:candies){
            max=(i>max)?i:max;
        }
        for(int i:candies){
            list.add((i+extraCandies)>=max);
        }
        return list;

    }
}