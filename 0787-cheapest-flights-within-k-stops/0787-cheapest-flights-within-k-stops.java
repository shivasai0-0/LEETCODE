class State {
    int node, cost, stops;
    State(int n, int c, int s) {
        node = n;
        cost = c;
        stops = s;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    // adjacency list
    ArrayList<int[]>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

    for (int[] f : flights) {
        adj[f[0]].add(new int[]{f[1], f[2]});
    }

    // dist[node][stops]
    int[][] dist = new int[n][k + 2];
    for (int i = 0; i < n; i++)
        Arrays.fill(dist[i], Integer.MAX_VALUE);

    PriorityQueue<State> pq =
        new PriorityQueue<>((a, b) -> a.cost - b.cost);

    pq.offer(new State(src, 0, 0));
    dist[src][0] = 0;

    while (!pq.isEmpty()) {

        State cur = pq.poll();

        int node = cur.node;
        int cost = cur.cost;
        int stops = cur.stops;

        // reached destination
        if (node == dst) return cost;

        // stop limit exceeded
        if (stops == k + 1) continue;

        for (int[] edge : adj[node]) {
            int next = edge[0];
            int price = edge[1];

            int newCost = cost + price;

            if (newCost < dist[next][stops + 1]) {
                dist[next][stops + 1] = newCost;
                pq.offer(new State(next, newCost, stops + 1));
            }
        }
    }

    return -1;
}

}