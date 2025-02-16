class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res= new int [n];
       int ind=n-1;
       int l=0;
       int r=n-1;
       while(l<=r){
        int sqOfLeft=nums[l]*nums[l];
        int sqOfRight=nums[r]*nums[r];
         if(sqOfRight> sqOfLeft){
            res[ind]=sqOfRight;
            r--;
         } else{
            res[ind]= sqOfLeft;
            l++;
         } ind--;

       }
       return res;


        
        
    }
}