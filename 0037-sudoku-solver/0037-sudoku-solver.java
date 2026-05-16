class Solution {
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    public boolean solver(char[][] board){
        int n=9;
        char[] num={'1','2','3','4','5','6','7','8','9'};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(int k=0;k<9;k++){
                        if(isSafe(board,i,j,num[k])){
                            board[i][j]=num[k];
                            if(solver(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board , int row , int col , char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        int rbox=0,cbox=0;
        rbox=(row<=2)?2:(row<=5)?5:8;
        cbox=(col<=2)?2:(col<=5)?5:8;
        for(int i=rbox-2;i<=rbox;i++){
            for(int j=cbox-2;j<=cbox;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}