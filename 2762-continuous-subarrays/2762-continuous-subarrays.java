class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0, r = 0;
        long count = 0;

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        while (r < nums.length) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r]) {
                max.pollLast();
            }
            max.offerLast(r);

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r]) {
                min.pollLast();
            }
            min.offerLast(r);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                if (max.peekFirst() == l) {
                    max.pollFirst();
                }

                if (min.peekFirst() == l) {
                    min.pollFirst();
                }

                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
}