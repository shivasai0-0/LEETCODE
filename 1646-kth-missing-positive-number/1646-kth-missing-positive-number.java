class Solution {
    private int binary(int[] arr , int k ){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            int miss=arr[mid]-(mid+1);
            if(miss<k){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        if(right!=-1){
            int diff=arr[right]-(right+1);
            return (arr[right]+(k-diff));
        }
        else{
            return k;
        }
    }
    public int findKthPositive(int[] arr, int k) {
       return binary(arr,k);
    }

}