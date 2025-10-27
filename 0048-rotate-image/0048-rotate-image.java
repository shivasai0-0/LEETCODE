class Solution {
    private void transpose(int[][] matrix){
        int temp;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i<j){
                    temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
    }
    private void reverse(int[][] a){
        int temp;
        for(int i=0;i<a.length;i++){
        int left=0;
        int right=a[0].length-1;
            while(left<right){
                temp=a[i][left];
                a[i][left]=a[i][right];
                a[i][right]=temp;
                left++;
                right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}