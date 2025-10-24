class Solution {
    public int trap(int[] height) {
        int max_index=0;
        int l=height.length;
        for(int i=0;i<l;i++){
            if(height[i]>height[max_index]){
                max_index=i;
            }
        }
        int max=height[0];
        int val=0;
        for(int i=0;i<max_index;i++){
            if(height[i]>max){
                max=height[i];
                continue;
            }
            val+=(max-height[i]);
        }
        max=height[l-1];
        for(int i=l-1;i>max_index;i--){
            if(height[i]>max){
                max=height[i];
                continue;
            }
            val+=(max-height[i]);
        }
        return val;

    }
}