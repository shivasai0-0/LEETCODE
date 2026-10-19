/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String,List<TreeNode>> map;
    public List<TreeNode> generateTrees(int n) {
        map= new HashMap<>();
        return solve(1,n);
    }
    private List<TreeNode> solve(int start , int end){
        String key= start+"-"+end;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if (start > end) return Arrays.asList((TreeNode) null);
        List<TreeNode> result= new ArrayList<>();
        for(int k=start;k<=end;k++){
            List<TreeNode> left=solve(start,k-1);
            List<TreeNode> right=solve(k+1,end);
            for(TreeNode i:left){
                for(TreeNode j:right){
                    result.add(new TreeNode(k,i,j)); 
                }
            }
        }
        map.put(key,result);
        return result;

    }
}