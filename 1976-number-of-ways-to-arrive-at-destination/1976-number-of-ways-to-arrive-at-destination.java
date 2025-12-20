class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] r : roads) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, 0}); // {dist, node}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                long wt = edge[1];

                long newDist = d + wt;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
