class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr=new int[52];
        int count=0;
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                int idx=ch-'A';
                if(arr[idx]==1&&arr[idx+26]==0){
                    count++;
                    arr[idx+26]=1;
                }
                else if(arr[idx]==0){
                    arr[idx]=-1;
                    arr[idx+26]=-1;
                }
            }
            else if(arr[ch-'a']==1&&arr[ch-'a'+26]==1){
                arr[ch-'a']=-1;
                arr[ch-'a'+26]=-1;
                count--;
            }
            else if(arr[ch-'a']!=-1&&arr[ch-'a'+26]!=1){
                arr[ch-'a']=1;
            }
        }
        return count;
    }
}