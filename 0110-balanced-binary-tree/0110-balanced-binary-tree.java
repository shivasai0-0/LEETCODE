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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(!checkBalance(root)) return false;
        return isBalanced(root.left)&&isBalanced(root.right); 
    }
    private int height(TreeNode node){
        if(node==null){ return 0;}
        return 1+Math.max(height(node.left),height(node.right));
    }
    private boolean checkBalance(TreeNode node){
        int diff=height(node.left)-height(node.right);
        diff=Math.abs(diff);
        if(diff>1){
            return false;
        }
        return true;
    }
}