class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<> ();
         int maxLen=0;
         for( int x: nums)
          set.add(x);
           for( int startElem : set ){
            if (!set.contains(startElem -1)){
                int len =1;
                while (set.contains( startElem + len))
                len++;
                 maxLen = Math.max(maxLen,len);
            }
           }
          return maxLen;
    }
}