class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else{
                int idx=st.pop();
                if(st.size()==0){
                    ans=ans+s.substring(idx+1,i);
                }
            }

        }
        return ans;

    }
}