class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Step 1: boundary rows
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);
            if (grid[row - 1][j] == 1) dfs(grid, row - 1, j);
        }

        // Step 2: boundary columns
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][col - 1] == 1) dfs(grid, i, col - 1);
        }

        // Step 3: count enclaves
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
