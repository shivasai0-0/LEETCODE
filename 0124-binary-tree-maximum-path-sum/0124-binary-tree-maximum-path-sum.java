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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        addPath(root);
        return max;
        
    }
    private int addPath(TreeNode node){
        if(node==null) return 0;
        int left=Math.max(0,addPath(node.left));
        int right=Math.max(0,addPath(node.right));
        int sum=left+right+node.val;
        max=Math.max(max,sum);
        return node.val+Math.max(left,right);
    }
}