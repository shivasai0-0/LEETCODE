class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<Integer> stinc = new Stack<>();
        Stack<Integer> stdec = new Stack<>();

        ininc(root, stinc);
        indec(root, stdec);

        return check(stinc, stdec, k);
    }

    public boolean check(Stack<Integer> stinc, Stack<Integer> stdec, int k) {
        while (!stinc.isEmpty() && !stdec.isEmpty() &&
               stinc.peek() > stdec.peek()) {

            int sum = stinc.peek() + stdec.peek();

            if (sum == k) return true;
            else if (sum > k) stinc.pop();
            else stdec.pop();
        }
        return false;
    }

    public void ininc(TreeNode root, Stack<Integer> stinc) {
        if (root != null) {
            ininc(root.left, stinc);
            stinc.push(root.val);
            ininc(root.right, stinc);
        }
    }

    public void indec(TreeNode root, Stack<Integer> stdec) {
        if (root != null) {
            indec(root.right, stdec);
            stdec.push(root.val);
            indec(root.left, stdec);
        }
    }
}