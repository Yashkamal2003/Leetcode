class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for( int i=0;i<n;i++){
            int curr= nums[i];
            while( nums[curr-1]!=curr)
            {
                int temp= nums[curr-1];
                nums[curr-1]= curr;
                curr=nums[i]= temp;

            }
        }
        for(int i=0;i<n;i++)
        if( nums[i]!=(i+1))
        return nums[i];
        return -1;
    }
}