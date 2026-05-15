class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=flowers.length;
        int[] start= new int[n];
        int[] end= new int[n];
        for(int i=0;i<n;i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int m=people.length;
        int[] ans= new int[m];
        for(int i=0;i<m;i++){
            int p=people[i];
            int started=upperbound(start,p);
            int ended=lowerbound(end,p);
            ans[i]=started-ended;
        }
        return ans;
    }
    public int upperbound(int[] nums, int x){
        int n=nums.length;
        int low=0;
        int high=n;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]<=x){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public int lowerbound(int[] nums, int x){
        int n=nums.length;
        int low=0;
        int high=n;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]<x){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}