class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        // reachable indices
        boolean[] visited = new boolean[n];

        // start index is reachable
        visited[0] = true;

        // farthest index already scanned
        int farthest = 0;

        for (int i = 0; i < n; i++) {

            // skip unreachable positions
            if (!visited[i]) {
                continue;
            }

            /*
             valid jump range:
             i + minJump -> i + maxJump
            */

            // start only from NEW positions
            int start = Math.max(i + minJump, farthest + 1);

            // ending boundary
            int end = Math.min(i + maxJump, n - 1);

            // scan only once globally
            for (int j = start; j <= end; j++) {

                // valid landing spot
                if (s.charAt(j) == '0') {
                    visited[j] = true;
                }
            }

            // remember already scanned range
            farthest = end;
        }

        return visited[n - 1];
    }
}