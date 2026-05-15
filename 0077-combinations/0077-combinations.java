class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sol= new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        int num=1;
        solve(sol,ans,n,k,num);
        return sol;
        
    }
    public void solve(List<List<Integer>> sol,List<Integer> ans ,int n ,int k , int num){
        if(ans.size()==k){
            sol.add(new ArrayList<>(ans));
            return;
        }
        if(num==n+1){
            return;
        }
        ans.add(num);
        solve(sol,ans,n,k,num+1);
        ans.remove(ans.size()-1);
        solve(sol,ans,n,k,num+1);

    }
}