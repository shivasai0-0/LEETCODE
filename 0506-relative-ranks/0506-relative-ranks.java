class Solution {
    public String[] findRelativeRanks(int[] score) {
               int n = score.length;
        String[] result = new String[n];

        // Step 1: Pair each score with its index
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i]; // score
            arr[i][1] = i;        // original index
        }

        // Step 2: Sort by score in descending order
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        // Step 3: Assign ranks
        for (int i = 0; i < n; i++) {
            int idx = arr[i][1];
            if (i == 0) result[idx] = "Gold Medal";
            else if (i == 1) result[idx] = "Silver Medal";
            else if (i == 2) result[idx] = "Bronze Medal";
            else result[idx] = String.valueOf(i + 1);
        }

        return result; 
    }
}