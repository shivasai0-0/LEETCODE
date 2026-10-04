class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1];
        return solve(s, 0, 0, dp);
    }

    private boolean solve(String s, int balance, int i, Boolean[][] dp) {
        if (balance < 0) {
            return false;
        }
        if (i == s.length()) {
            return balance == 0;
        }
        if (dp[i][balance] != null) {
            return dp[i][balance];
        }
        char ch = s.charAt(i);
        if (ch == '(') {
            return dp[i][balance] =
                solve(s, balance + 1, i + 1, dp);
        }
        if (ch == ')') {
            return dp[i][balance] =
                balance > 0 && solve(s, balance - 1, i + 1, dp);
        }
        return dp[i][balance] =
            solve(s, balance + 1, i + 1, dp)
            || (balance > 0 && solve(s, balance - 1, i + 1, dp))
            || solve(s, balance, i + 1, dp);
    }
}