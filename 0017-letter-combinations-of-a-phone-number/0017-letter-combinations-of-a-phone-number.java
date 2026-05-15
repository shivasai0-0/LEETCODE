class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> sol= new ArrayList<>();
        String ans="";
        solve(sol,map,digits,digits.length(),0,ans);
        return sol;
    }
    public void solve(List<String> sol ,Map<Character,String> map , String digits ,int n , int index,String ans ){
        if(index==n){
            sol.add(ans);
            return;
        }
        String alpha = map.get(digits.charAt(index));
        for(char ch:alpha.toCharArray()){
            solve(sol,map,digits,n,index+1,ans+ch);
        }

    }
}