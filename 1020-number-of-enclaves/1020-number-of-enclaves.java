class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int res = dfs(grid, i, j, visited);
                    if (res > 0) count += res;
                }
            }
        }
        return count;
    }

    int dfs(int[][] grid, int i, int j, int[][] visited) {

        // ✅ SAFETY GUARD (prevents exception)
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;

        boolean isBoundary =
                i == 0 || j == 0 ||
                i == grid.length - 1 ||
                j == grid[0].length - 1;

        int up = dfs(grid, i - 1, j, visited);
        int down = dfs(grid, i + 1, j, visited);
        int left = dfs(grid, i, j - 1, visited);
        int right = dfs(grid, i, j + 1, visited);

        if (isBoundary || up == -1 || down == -1 || left == -1 || right == -1) {
            return -1;
        }

        return 1 + up + down + left + right;
    }
}
