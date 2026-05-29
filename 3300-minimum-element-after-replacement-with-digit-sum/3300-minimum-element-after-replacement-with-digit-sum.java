class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                sum += c - '0';
            }
            ans = Math.min(ans, sum);
        }

        return ans;
    }
}