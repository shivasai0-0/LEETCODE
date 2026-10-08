class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=n*m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int midrow=mid/m;
            int midcol=mid%m;
            if(matrix[midrow][midcol]==target){
                return true;
            }
            if(matrix[midrow][midcol]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
        
    }
}