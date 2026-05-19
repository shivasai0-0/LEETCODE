class Solution {
    public boolean isUgly(int n) {
        boolean flag=true;
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(flag&&n!=1){
            boolean inflag=false;
            if(n%2==0){
                inflag=true;
                n=n/2;
            }
            if(n%3==0){
                inflag=true;
                n=n/3;
            }
            if(n%5==0){
                inflag=true;
                n=n/5;
            }
            flag=inflag;
        }
        if(n==1){
            return true;
        }
        return false;

    }
}