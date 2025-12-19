class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 1) {
            return new int[]{0};
        }

        int[][] adjmat = new int[numCourses][numCourses];
        int[] inc = new int[numCourses];
        ArrayList<Integer> out = new ArrayList<>();

        for (int[] i : prerequisites) {
            adjmat[i[1]][i[0]] = 1;
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

            for (int i = 0; i < numCourses; i++) {
                if (adjmat[p][i] == 1) {
                    inc[i]--;
                    if (inc[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        int[] result = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            result[i] = out.get(i);
        }

        return result.length==numCourses?result: new int[0];
    }
}
