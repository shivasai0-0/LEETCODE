class Solution {

    int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        long ans = (fact(count) * fact(n - count)) % MOD;

        return (int) ans;
    }

    public boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public long fact(int n) {

        long fac = 1;

        for (int i = 1; i <= n; i++) {
            fac = (fac * i) % MOD;
        }

        return fac;
    }
}