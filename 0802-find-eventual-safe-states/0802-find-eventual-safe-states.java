class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<Integer>[] radj = new ArrayList[n];
        int[] inc= new int[n];
        for (int i = 0; i < n; i++) radj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                radj[v].add(i);
                inc[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> out = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            if (inc[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int p = q.remove();
            out.add(p);

            for (int i : radj[p]) {
                inc[i]--;
                if (inc[i] == 0) {
                    q.add(i);
                }
            }
        }

        Collections.sort(out);
        return out;
    }

}