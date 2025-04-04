class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq= new ArrayDeque<>();
        int ans[]=new  int[nums.length-k+1];
        for( int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && dq.peekLast()< nums[i])
            dq.removeLast();
            dq.addLast(nums[i]);
        }
         for (int i=k;i<nums.length;i++)
         {
             ans[i- k]= dq.peekFirst();

             int outgoingElement=nums[i-k];
              if(outgoingElement == dq.peekFirst())
              dq.removeFirst();
              int incomingElement =nums[i];
              while(!dq.isEmpty() && dq.peekLast()< incomingElement)
              dq.removeLast();
              dq.addLast(incomingElement);
         }
         ans[ans.length -1]= dq.peekFirst();
         return ans;
    }
}