import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        int[] small, bigger;

        if(nums1.length < nums2.length){
            small = nums1;
            bigger = nums2;
        } else {
            small = nums2;
            bigger = nums1;
        }

        // store frequency
        for(int i : bigger){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // controlled matching
        for(int i : small){
            if(map.containsKey(i) && map.get(i) > 0){
                result.add(i);
                map.put(i, map.get(i) - 1); // 🔥 reduce usage
            }
        }

        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }

        return arr;
    }
}