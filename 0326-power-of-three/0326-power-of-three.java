class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){ return false;}
        if(n==1|n==3){ return true;}
        long sum=3;
        while(n>sum){
            sum*=3;
            if(n==sum){ return true;}
        }
        return false;

    }
}