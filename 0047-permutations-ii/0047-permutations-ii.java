class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(sol, new ArrayList<>(), nums, visited);
        return sol;
    }
    public void solve(List<List<Integer>> sol,
                      List<Integer> ans,
                      int[] nums,
                      boolean[] visited) {
        if(ans.size() == nums.length) {
            sol.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i])
                continue;
            if(i > 0 &&
               nums[i] == nums[i - 1] &&
               !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            ans.add(nums[i]);
            solve(sol, ans, nums, visited);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }
}