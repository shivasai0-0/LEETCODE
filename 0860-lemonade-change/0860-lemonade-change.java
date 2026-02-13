class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] freq=new int[2];
        for(int i:bills){
            if(i==5){ freq[0]++;}
            else if(i==10){ 
                freq[1]++;
                if(freq[0]>0){
                    freq[0]--;
                }
                else { return false;}
            }
            else{
                if(freq[1]>0&&freq[0]>0){
                    freq[1]--;
                    freq[0]--;
                }
                else if(freq[0]>=3){
                    freq[0]-=3;
                }
                else{ return false;}
            }
        }
        return true;
        
    }
}