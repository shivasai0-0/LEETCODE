class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited=new int[row][col];
        for (int j = 0; j < col; j++) {
            if (board[0][j] =='O'&&visited[0][j]==0) dfs(board,visited, 0, j);
            if (board[row - 1][j] =='O'&&visited[row-1][j]==0) dfs(board,visited, row - 1, j);
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] =='O'&&visited[i][0]==0) dfs(board,visited, i, 0);
            if (board[i][col - 1] =='O'&&visited[i][col-1]==0) dfs(board,visited, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] =='O'&&visited[i][j]==0) board[i][j]='X';
            }
        }
    }

    void dfs(char[][] grid,int[][] visited, int i, int j) {
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] =='X'||visited[i][j]==1) {
            return;
        }

        visited[i][j] = 1;

        dfs(grid,visited, i + 1, j);
        dfs(grid,visited, i - 1, j);
        dfs(grid,visited, i, j + 1);
        dfs(grid,visited, i, j - 1);
    }
}