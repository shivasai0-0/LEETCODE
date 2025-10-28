class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def binary(left, right):
            if left > right:
                return -1
            mid = (left + right) // 2
            count=mid
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                return binary(mid + 1, right)
            else:
                return binary(left, mid - 1)
        x = binary(0, len(nums) - 1)
        if x == -1:
            return [-1, -1]
        left, right = x, x
        while left - 1 >= 0 and nums[left - 1] == target:
            left -= 1
        while right + 1 < len(nums) and nums[right + 1] == target:
            right += 1
        
        return [left, right]

        