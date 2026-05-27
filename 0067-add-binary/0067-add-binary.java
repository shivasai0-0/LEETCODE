class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb= new StringBuilder();
        int an=a.length()-1;
        int bn=b.length()-1;
        int carry=0;
        while(an>=0&&bn>=0){
            int num=a.charAt(an)+b.charAt(bn)+carry-'0'-'0';
            carry=num/2;
            sb.append(Integer.toString(num%2));
            an--;
            bn--;
            
        }
        while(an>=0){
            int num=a.charAt(an)-'0'+carry;
            carry=num/2;
            sb.append(Integer.toString(num%2));
            an--;
        }
        while(bn>=0){
            int num=b.charAt(bn)-'0'+carry;
            carry=num/2;
            sb.append(Integer.toString(num%2));
            bn--;
        }
        if(carry!=0){
            sb.append(Integer.toString(carry));
        }
        return sb.reverse().toString();

    }
}