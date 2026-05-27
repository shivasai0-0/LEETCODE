class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        if(m>n||m==0){
            return -1;
        }
        int i=0;
        int j=0;
        int fidx=-1;
        int idx=0;
        boolean flag=false;
        while(i<n&&j<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                if(!flag){
                    fidx=i;
                    idx=fidx;
                    flag=true;
                }
                i++;
                j++;
            }
            else{
                i=idx+1;
                idx++;
                fidx=-1;
                j=0;
                flag=false;
            }
        }
        return (j==m)?fidx:-1;
    }
}