class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        def minindex(left,right):
            while(left<right):
                mid=(left+right)//2
                if(nums[mid]>nums[right]):left=mid+1
                elif(nums[mid]<nums[right]): right=mid
                else:
                    if right > 0 and nums[right - 1] > nums[right]:
                        left = right
                        break
                    right -= 1
            return left
        index=minindex(0,len(nums)-1)
        new=nums[index:]+nums[:index]
        def binary(left, right):
            if left > right:
                return -1
            mid = (left + right) // 2
            if new[mid] == target:
                return mid
            elif new[mid] < target:
                return binary(mid + 1, right)
            else:
                return binary(left, mid - 1)
        
        x=binary(0, len(nums) - 1)
        if(x==-1): return False
        else: return True
        