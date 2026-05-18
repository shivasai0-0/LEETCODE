class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            n=-n;
            x=1/x;
        }
        return solve(x,n);
    }
    public double solve(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half=solve(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return x*half*half;
    }
}