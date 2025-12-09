class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,freq=0,max=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            int val=map.getOrDefault(s.charAt(j),0)+1;
            map.put(s.charAt(j),val);
            freq=Math.max(freq,val);
            int size=j-i+1;
            if((size-freq)>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
                size--;
            }
            max=Math.max(max,size);
            j++;


        }
        return max;
        
    }
}