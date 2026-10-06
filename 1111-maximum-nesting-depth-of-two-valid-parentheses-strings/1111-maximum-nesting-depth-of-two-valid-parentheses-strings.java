class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int b=0;
        int n=seq.length();
        int[] ans= new int[n];
        for(int i=0;i<n;i++){
            char ch=seq.charAt(i);
            if(ch=='('){
                ans[i]=b%2;
                b++;
            }
            else{
                b--;
                ans[i]=b%2;
            }

        }
        return ans;
    }
}