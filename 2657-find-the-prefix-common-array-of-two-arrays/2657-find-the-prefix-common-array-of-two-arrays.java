class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] num = new int[n + 1];
        int[] ans = new int[n];

        int common = 0;

        for (int i = 0; i < n; i++) {

            num[A[i]]++;

            if (num[A[i]] == 2) {
                common++;
            }

            num[B[i]]++;

            if (num[B[i]] == 2) {
                common++;
            }

            ans[i] = common;
        }

        return ans;
    }
}