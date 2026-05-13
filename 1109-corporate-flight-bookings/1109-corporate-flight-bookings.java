class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] seats = new int[n + 1];

        for (int i = 0; i < bookings.length; i++) {

            int first = bookings[i][0];
            int last = bookings[i][1];
            int val = bookings[i][2];

            seats[first - 1] += val;

            if (last < n) {
                seats[last] -= val;
            }
        }

        int[] ans = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += seats[i];
            ans[i] = sum;
        }

        return ans;
    }
}