class Solution {
    public void sortColors(int[] nums) {
       int i=0;
       int j=0;
        int k= nums.length-1;
        while(j<= k){
            switch(nums[j]){
                case 0:
                int temp= nums[j];
                nums[j]= nums[i];
                nums[i]= temp;
                i++;
                j++;
                break;
                case 1:
                j++; 
                break;
                 case 2:
                 temp= nums[j];
                 nums[j]= nums[k];
                 nums[k]= temp;
                 k--;
            }
        }  
     }
}