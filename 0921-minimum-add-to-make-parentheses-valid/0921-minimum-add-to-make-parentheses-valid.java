class Solution {
    public int minAddToMakeValid(String s) {
        int b=0;
        int a=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                b++;
            }
            else{
                if(b==0){
                    a++;
                }
                else{
                    b--;
                }
            }

        }
        return b+a;
    }
}