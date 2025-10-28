class Solution {
    private boolean calhrs(int[] a, int k,int h){
        int sum=0;
        for(int i=0; i<a.length;i++){
            sum+=((a[i]+k-1)/k);
        }
        return (sum<=h) ? true:false;
    }
    private int binary(int[] a, int h){
        int left=1;
        int right=Arrays.stream(a).max().getAsInt();
        while(left<right){
            int mid=(left+right)/2;
            if(calhrs(a,mid,h)==true){
                right=mid;
            }
            else{
                left=mid+1;  
            }
            
        }
        return left;
    }
    public int minEatingSpeed(int[] piles, int h) {
        return binary(piles,h);
    }
}