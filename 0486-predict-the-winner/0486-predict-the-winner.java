class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        // Optimization: If the length is even, Player 1 can always win or tie
        if (n % 2 == 0) {
            return true;
        }
        
        // dp[j] will store the maximum score difference for the subarray nums[i...j]
        int[] dp = new int[n];
        
        // Base case: subarrays of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        
        // Build the DP table bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        // If the final score difference for the entire array is >= 0, Player 1 wins
        return dp[n - 1] >= 0;
    }
}

