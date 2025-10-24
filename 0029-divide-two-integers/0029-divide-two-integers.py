class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31
        if divisor == 0:
            raise ZeroDivisionError("division by zero")
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
        negative = (dividend < 0) ^ (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        nums = {}
        current_sum = divisor
        power = 1
        while dividend >= current_sum + current_sum:
            nums[current_sum] = power
            current_sum += current_sum
            power += power
        nums[current_sum] = power
        del power
        quotient = 0
        for num in sorted(nums.keys(), reverse=True):
            if dividend >= num:
                dividend -= num
                quotient += nums[num]
        del nums, num 
        if negative:
            quotient = -quotient
        return quotient
        
        
        
        
        
        