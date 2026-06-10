class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] temp=temperatures;
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&temp[st.peek()]<=temp[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return ans;
        
    }
}