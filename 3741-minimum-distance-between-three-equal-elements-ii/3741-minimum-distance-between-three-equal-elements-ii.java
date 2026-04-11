import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        Map<Integer, Integer> map = new HashMap<>();

        // left array (previous occurrence)
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                left[i] = map.get(nums[i]);
            }
            map.put(nums[i], i);
        }

        map.clear();

        // right array (next occurrence)
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                right[i] = map.get(nums[i]);
            }
            map.put(nums[i], i);
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (left[i] != -1 && right[i] != -1) {
                int dist = 2 * (right[i] - left[i]);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}