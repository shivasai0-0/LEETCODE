class Solution {
    public int maximumLengthSubstring(String s) {
        int[] lower = new int[26];
        Arrays.fill(lower,0);
        int l=0;
        int i=0;
        int n=s.length();
        int max=Integer.MIN_VALUE;
        while(i<n&&l<n){
            char ch=s.charAt(i);
            lower[ch-'a']+=1;
            if(lower[ch-'a']==3){
                while(lower[ch-'a']!=2){
                    lower[s.charAt(l)-'a']-=1;
                    l+=1;
                }
            }
            int len=i-l+1;
            max=(max>len)?max:len;
            i++;
        }
        return max;
    }
}