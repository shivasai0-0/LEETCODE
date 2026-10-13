

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            long square = (long) nums[i] * nums[i];

            if (i < n / 2) {
                low += square;
            } else {
                high += square;
            }
        }

        return high - low;
    }
}
