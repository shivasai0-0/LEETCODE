import java.util.*;

class Solution {

    int[] parent;
    int[] size;

    public int largestComponentSize(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        parent = new int[max + 1];
        size = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // connect number with its factors
        for (int num : nums) {

            for (int factor = 2; factor * factor <= num; factor++) {

                if (num % factor == 0) {

                    union(num, factor);
                    union(num, num / factor);
                }
            }
        }

        HashMap<Integer, Integer> componentSize = new HashMap<>();

        int ans = 0;

        for (int num : nums) {

            int root = find(num);

            componentSize.put(root,
                    componentSize.getOrDefault(root, 0) + 1);

            ans = Math.max(ans, componentSize.get(root));
        }

        return ans;
    }

    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }

        return parent[x];
    }

    public void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        // union by size
        if (size[pa] < size[pb]) {

            parent[pa] = pb;
            size[pb] += size[pa];

        } else {

            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}