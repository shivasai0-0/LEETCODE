class Solution {
    private boolean bouque(int[] days , int m , int k , int x){
        int count=0;
        for(int i=0;i<days.length;i++ ){
            if(days[i]<=x){
                count++;
            }
            else{
                count=0;
            }
            if(count==k){
                m--;
                count=0;
            }
        }
        return (m<=0) ? true:false;
    }
    private int binary(int[] a, int m , int k){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(bouque(a,m,k,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if( (long)m*k>bloomDay.length){ return -1;}
        return binary(bloomDay,m,k);
    }
}