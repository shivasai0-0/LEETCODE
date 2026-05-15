class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] cols= new int[n];
        List<List<String>> list = new ArrayList<>();
        solve(list,cols,n,0);
        return list;


    }
    public void solve(List<List<String>> list,int[] cols,int n,int row){
        if(row==n){
            list.add(solution(cols,n));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(cols,row,col)){
                cols[row]=col;
                solve(list,cols,n,row+1);
                cols[row]=0;
            }
        }
    }
    public List<String> solution(int[] cols, int n) {

        List<String> board = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < n; j++) {

                if(cols[i] == j)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            board.add(sb.toString());
        }

        return board;
    }
    public boolean isSafe(int[] cols ,int row , int col ){
        for(int i=0;i<row;i++){
            if(cols[i]==col){
                return false;
            }
            if(Math.abs(i-row)==Math.abs(cols[i]-col)){
                return false;
            }
        }
        return true;
    }
}