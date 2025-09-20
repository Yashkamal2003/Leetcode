class Solution {
    public int characterReplacement(String s, int k) {
     Map<Character,Integer> map=new HashMap<>();
     int start=0;
     int MaxFreq=0;
     int MaxLen=0;
     for( int end=0;end<s.length();end++){
        map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)+1);

        MaxFreq=Math.max(MaxFreq,map.get(s.charAt(end)));
        while ((end-start+1) -MaxFreq>k){
            map.put(s.charAt(start),map.get(s.charAt(start))-1);
            start++;
        }
        MaxLen=Math.max(MaxLen,end-start+1);
     }
      return MaxLen;
         }
}