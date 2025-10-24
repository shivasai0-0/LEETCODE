class Solution:
    def sumDivisibleByK(self, nums: List[int], k: int) -> int:
        freq={i:0 for i in nums}
        for i in nums:
            freq[i]+=1
        count=0
        for i in freq:
            if(freq[i]%k==0):
                count+=i*freq[i]
        return count
