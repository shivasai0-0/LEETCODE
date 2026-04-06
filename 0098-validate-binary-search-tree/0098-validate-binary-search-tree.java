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
    public boolean isValidBST(TreeNode root) {
        // return check(root);
        List<Integer> r= inorder(root);
        int num=r.get(0);
        for(int i=1;i<r.size();i++){
            if(num>=r.get(i)){
                return false;
            }
            num=r.get(i);
        }
        return true;
    }
    boolean check(TreeNode root){
        if(root==null){
            return true;
        }
        boolean lbool=true;
        boolean rbool=true;
        if(root.left!=null&&root.left.val>=root.val){
            lbool=false;
        }
        if(root.right!=null&&root.right.val<=root.val){
            rbool=false;
        }
        return lbool&&rbool&&check(root.right)&&check(root.left);

    }
    List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);

            curr = curr.right;
        }

        return result;
    }
}