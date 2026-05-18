class Solution {
    public int superPow(int a, int[] b) {
        // Drop the base immediately to ensure safety from integer overflow
        a %= 1337; 
        
        int result = 1;
        
        // Loop forward from the first digit to the last digit
        for (int i = 0; i < b.length; i++) {
            // 1. Shift previous total's place-value up by raising it to the power of 10
            long shiftedResult = yourRecursivePow(result, 10);
            
            // 2. Calculate the power for the current digit
            long currentDigitPower = yourRecursivePow(a, b[i]);
            
            // 3. Combine them together safely using modulo arithmetic
            result = (int) ((shiftedResult * currentDigitPower) % 1337);
        }
        
        return result;
    }

    // YOUR EXACT RECURSIVE EVEN/ODD FUNCTION
    private long yourRecursivePow(long base, int exp) {
        if (exp == 0) return 1;

        // If exp is ODD
        if (exp % 2 != 0) {
            return (base%1337 * yourRecursivePow(base, exp - 1)%1337) % 1337;
        } 
        // If exp is EVEN
        else {
            long halfResult = yourRecursivePow(base, exp / 2)%1337;
            return (halfResult * halfResult) % 1337;
        }
    }
}
