class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def binary(left, right):
            if left > right:
                return -1
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                return binary(mid + 1, right)
            else:
                return binary(left, mid - 1)
        
        return binary(0, len(nums) - 1)

        