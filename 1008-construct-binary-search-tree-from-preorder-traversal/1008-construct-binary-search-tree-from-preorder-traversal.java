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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i:preorder){
            root=insert(root,i);
        }
        return root;
    }
    public TreeNode insert(TreeNode root ,int x){
        if(root==null){
            return new TreeNode(x);
        }
        if(root.val>x){
            root.left=insert(root.left,x);
        }
        else{
            root.right=insert(root.right,x);
        }
        return root;
    }
}