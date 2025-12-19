class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }

        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inc = new int[numCourses];
        ArrayList<Integer> out = new ArrayList<>();

        for (int[] i : prerequisites) {
            adj[i[1]].add(i[0]);
            inc[i[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inc[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int p = q.remove();
            out.add(p);

            for (int i : adj[p]) {
                inc[i]--;
                if (inc[i] == 0) {
                    q.add(i);
                }
            }
        }

        int[] result = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            result[i] = out.get(i);
        }

        return result.length == numCourses ? true : false;
    }
}