class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int LIS[]= new int[n+1];
        int LDS[]= new int [n+1];
        //calculate Lis
         LIS[0]=1;
        for(int i=1;i<n ;i++){
            int LIScurrElement=0;
            for(int j=i-1;j>=0;j--)
            if(nums[i]> nums[j])
            LIScurrElement=Math.max(LIScurrElement,LIS[j]);
            LIS[i]=1+LIScurrElement;
        }
        //calculate lds
        LDS[n-1]=1;
        for( int i =n-2; i>=0;i--){
            int LDScurrElement=0;
            for(int j=i+1;j<n;j++)
            if(nums[i] > nums[j])
            LDScurrElement = Math.max(LDScurrElement,LDS[j]);
            LDS[i]=1+LDScurrElement;
        }
        
        
        //calculate lbs
        int ans=0;
        for( int i=1;i<(n-1);i++)
            if(LIS[i]>1 && LDS[i]>1)
            ans=Math.max(LIS[i]+LDS[i]-1,ans);
            return ans;
        
    
    }
}