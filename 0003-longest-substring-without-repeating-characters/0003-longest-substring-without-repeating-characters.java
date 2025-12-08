import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int maxcount=0;
        int len =s.length();
        while(r<len){
            if(map.containsKey(s.charAt(r))){
                int n=map.get(s.charAt(r))+1;
                l=(l<n)?n:l;
            }
            map.put(s.charAt(r),r);
            if(maxcount<(r-l+1)){
                maxcount=r-l+1;
            }
            r++;
        }
        return maxcount;
        
    }
}