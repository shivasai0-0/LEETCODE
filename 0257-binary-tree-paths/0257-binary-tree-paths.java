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

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        solve(root, "", ans);

        return ans;
    }

    public void solve(TreeNode root, String path, List<String> ans){

        if(root == null){
            return;
        }

        if(path.length() == 0){
            path += root.val;
        }
        else{
            path += "->" + root.val;
        }

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        solve(root.left, path, ans);

        solve(root.right, path, ans);
    }
}