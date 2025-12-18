class point {
    int row, col, dist;
    point(int r, int c, int d) {
        row = r;
        col = c;
        dist = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        Queue<point> q = new LinkedList<>();
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    q.add(new point(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            point p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = p.row + drow[i];
                int nc = p.col + dcol[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col
                        && visited[nr][nc] == 0) {

                    mat[nr][nc] = p.dist + 1;
                    visited[nr][nc] = 1;
                    q.add(new point(nr, nc, p.dist + 1));
                }
            }
        }
        return mat;
    }
}
