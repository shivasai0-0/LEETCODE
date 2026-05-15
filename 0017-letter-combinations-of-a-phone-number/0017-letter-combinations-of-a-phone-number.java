class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> sol = new ArrayList<>();

        if(digits.length() == 0)
            return sol;

        Map<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        solve(sol, map, digits, 0, new StringBuilder());

        return sol;
    }

    public void solve(List<String> sol,
                      Map<Character,String> map,
                      String digits,
                      int index,
                      StringBuilder ans) {

        if(index == digits.length()) {
            sol.add(ans.toString());
            return;
        }

        String alpha = map.get(digits.charAt(index));

        for(char ch : alpha.toCharArray()) {

            ans.append(ch);

            solve(sol, map, digits, index + 1, ans);

            ans.deleteCharAt(ans.length() - 1);
        }
    }
}