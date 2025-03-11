class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int  leftProduct[]= new int[n];
        int rightProduct[]= new int [n];
        for( int i=0, temp=1 ;i<n ;i++){
            leftProduct[i]= temp;
            temp *= nums[i];
        }
        for( int i= n-1,temp=1; i>=0;i--){
            rightProduct[i]= temp;
            temp *= nums[i];
        }
         int result[]= new int[n];
         for( int i=0;i<n ;i++){
            result[i]= leftProduct[i]*rightProduct[i];
         }
          return result;

    }
}