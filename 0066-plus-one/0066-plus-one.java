class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int ans = digits[i] + carry;
            digits[i] = ans % 10;
            carry = ans / 10;
        }

        if (carry == 1) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }
}