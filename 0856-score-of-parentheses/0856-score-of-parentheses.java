class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        for(char i:s.toCharArray()){
            if(i=='('){
                st.push(-1);
            }
            else{
                int sum=0;
                if(st.peek()==-1){
                    st.pop();
                    st.push(1);
                    continue;
                }
                while(st.peek()!=-1){
                    int num=st.pop();
                    sum+=num;

                }
                st.pop();
                sum*=2;
                st.push(sum);
            }
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}