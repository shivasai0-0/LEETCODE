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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){ return new TreeNode(val);}
        TreeNode parent=null;
        TreeNode temp=root;
        while(temp!=null){
            parent=temp;
            if(temp.val>val){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
        if(parent.val>val&&parent.left==null){
            parent.left=new TreeNode(val);
        }
        if(parent.val<val&&parent.right==null){
            parent.right=new TreeNode(val);
        }
        return root;
    }
}