class Solution {
    public List<Integer> findMissingElements(int[] nums) {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    Set<Integer> newset= new HashSet<>();
    for(int i: nums){
        min=(min<=i)?min:i;
        max=(max>=i)?max:i;
        newset.add(i);
    }
    List<Integer> missing = new ArrayList<>();
    for(int i=min;i<=max;i++){
        if(!newset.contains(i)){
            missing.add(i);
        }
    }
    return missing;
    }
}