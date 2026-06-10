

class Solution {
    // Sparse tables for max and min queries
    private int[][] maxSt;
    private int[][] minSt;
    private int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Precompute logarithms for O(1) Sparse Table queries
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }
        
        int maxLog = lg[n] + 1;
        maxSt = new int[maxLog][n];
        minSt = new int[maxLog][n];
        
        for (int i = 0; i < n; i++) {
            maxSt[0][i] = nums[i];
            minSt[0][i] = nums[i];
        }
        
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxSt[j][i] = Math.max(maxSt[j - 1][i], maxSt[j - 1][i + (1 << (j - 1))]);
                minSt[j][i] = Math.min(minSt[j - 1][i], minSt[j - 1][i + (1 << (j - 1))]);
            }
        }
        
        // 2. Max-Heap elements structured as: [subarray_value, left_index, right_index]
        // Sorted in descending order of subarray_value
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        // Initialize heap with the largest span for each starting index 'l'
        for (int l = 0; l < n; l++) {
            int val = queryValue(l, n - 1);
            maxHeap.offer(new int[]{val, l, n - 1});
        }
        
        long totalMaximumValue = 0;
        
        // 3. Extract the top k maximum subarrays
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int val = curr[0];
            int l = curr[1];
            int r = curr[2];
            
            totalMaximumValue += val;
            k--;
            
            // Push the next best option for this starting point
            if (r > l) {
                int nextR = r - 1;
                int nextVal = queryValue(l, nextR);
                maxHeap.offer(new int[]{nextVal, l, nextR});
            }
        }
        
        return totalMaximumValue;
    }
    
    // O(1) Range Max - Range Min helper function
    private int queryValue(int l, int r) {
        int j = lg[r - l + 1];
        int maxVal = Math.max(maxSt[j][l], maxSt[j][r - (1 << j) + 1]);
        int minVal = Math.min(minSt[j][l], minSt[j][r - (1 << j) + 1]);
        return maxVal - minVal;
    }
}