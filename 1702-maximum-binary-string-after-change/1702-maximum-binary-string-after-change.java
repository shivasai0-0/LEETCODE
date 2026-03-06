class Solution {
    public String maximumBinaryString(String binary) {

        int n = binary.length();
        int zeroCount = 0;
        int firstZero = -1;

        for(int i=0;i<n;i++){
            if(binary.charAt(i)=='0'){
                zeroCount++;
                if(firstZero==-1) firstZero=i;
            }
        }

        if(zeroCount<=1) return binary;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) sb.append('1');

        sb.setCharAt(firstZero + zeroCount - 1,'0');

        return sb.toString();
    }
}