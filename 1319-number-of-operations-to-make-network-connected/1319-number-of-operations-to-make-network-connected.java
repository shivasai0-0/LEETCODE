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
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        Disjoint ds = new Disjoint(n);
        for (int[] e : connections) {
            ds.union(e[0], e[1]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                components++;
            }
        }
        return components - 1;
    }
}
