class Solution {
    public String countAndSay(int n) {
        StringBuilder sb= new StringBuilder("1");
        for(int k=2;k<=n;k++){
            String str=sb.toString();
            sb.setLength(0);
            char prev='?';
            int count=0;
            for(char i:str.toCharArray()){
                if(prev=='?'){
                    prev=i;
                    count++;
                }
                else if(prev!=i){
                    sb.append(Integer.toString(count));
                    sb.append(prev);
                    prev=i;
                    count=1;
                }
                else{
                    count++;
                }
            }
            sb.append(Integer.toString(count));
            sb.append(prev);

        }
        return sb.toString();
    }
}