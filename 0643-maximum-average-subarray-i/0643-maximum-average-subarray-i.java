class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        int sum = 0;
        double maxavg = -1e9;
        while (j < k) {
            sum += nums[j];
            j++;
        }
        maxavg = (double) sum / k;
        while (j < nums.length) {
            sum = sum + nums[j] - nums[i];
            double avg = (double) sum / k;
            maxavg = Math.max(maxavg, avg);
            i++;
            j++;
        }

        return maxavg;
    }
}
