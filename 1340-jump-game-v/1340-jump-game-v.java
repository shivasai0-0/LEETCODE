class Solution {

    int[] dp;

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        // dp[i] = maximum indices visitable starting from i
        dp = new int[n];

        int ans = 1;

        // Try starting from every index
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d) {

        // Already computed
        if (dp[i] != 0) {
            return dp[i];
        }

        int best = 1; // current index itself

        // Explore LEFT
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            // blocker found
            if (arr[j] >= arr[i]) {
                break;
            }

            best = Math.max(best, 1 + dfs(j, arr, d));
        }

        // Explore RIGHT
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {

            // blocker found
            if (arr[j] >= arr[i]) {
                break;
            }

            best = Math.max(best, 1 + dfs(j, arr, d));
        }

        // Store result
        dp[i] = best;

        return best;
    }
}