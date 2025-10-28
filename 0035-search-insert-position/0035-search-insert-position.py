class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def binary(left, right):
            if left > right:
                return left
            mid = (left + right) // 2
            count=mid
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                return binary(mid + 1, right)
            else:
                return binary(left, mid - 1)
        return binary(0, len(nums) - 1)
        