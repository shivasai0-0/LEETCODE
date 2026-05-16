class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            if (n == 1) {
                return true;
            }

            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            n = nextnum(n);
        }
    }

    public int nextnum(int n) {
        int sum = 0;

        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n = n / 10;
        }

        return sum;
    }
}