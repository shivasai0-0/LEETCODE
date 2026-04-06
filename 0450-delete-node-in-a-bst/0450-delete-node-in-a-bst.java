class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) return root;
        if (curr.left != null && curr.right != null) {
            TreeNode succParent = curr;
            TreeNode succ = curr.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            curr.val = succ.val;
            parent = succParent;
            curr = succ;
        }
        TreeNode child;
        if (curr.left != null) {
            child = curr.left;
        } else {
            child = curr.right;
        }
        if (parent == null) {
            return child;
        }
        if (parent.left == curr) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }
}