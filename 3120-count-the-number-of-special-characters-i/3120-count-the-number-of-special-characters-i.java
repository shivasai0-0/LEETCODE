class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr= new int[52];
        int count=0;
        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                int idx=ch-'a';
                if(arr[idx+26]==1&&arr[idx]==0){
                    count++;
                }
                arr[idx]=1;
            }
            else{
                int idx=ch-'A';
                if(arr[idx+26]==0&&arr[idx]==1){
                    count++;
                }
                arr[idx+26]=1;
            }
        }
        return count;
    }
}