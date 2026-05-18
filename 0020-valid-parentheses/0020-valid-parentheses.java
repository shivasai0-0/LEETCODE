class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            else if(st.isEmpty()){
                return false;
            }
            else{
                char top=st.peek();
                if(ch==')'&&top!='(') return false;
                if(ch==']'&&top!='[') return false;
                if(ch=='}'&&top!='{') return false;
                st.pop();     
            }
        }
        return st.isEmpty();
    }
}