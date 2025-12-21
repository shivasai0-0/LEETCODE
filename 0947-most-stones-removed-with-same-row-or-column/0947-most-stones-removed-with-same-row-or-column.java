class Disjoint {
    int[] parent;
    int[] size;

    Disjoint(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int x) {
        if (x == parent[x]) return x;
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int OFFSET = 10001;
        Disjoint ds = new Disjoint(20005);

        HashSet<Integer> active = new HashSet<>();

        for (int[] s : stones) {
            int row = s[0];
            int col = s[1] + OFFSET;

            ds.union(row, col);
            active.add(row);
            active.add(col);
        }

        int components = 0;
        for (int x : active) {
            if (ds.findParent(x) == x) {
                components++;
            }
        }

        return stones.length - components;
    }
}
