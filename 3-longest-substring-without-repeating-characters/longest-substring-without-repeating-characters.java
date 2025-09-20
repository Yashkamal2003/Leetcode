class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        Map<Character,Integer> map= new HashMap<>();
        int count=0;
        for( int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1)
            {
               // char charStart=s.charAt(start);
               //map.put(charStart,map.get(charStart)-1);
               map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            count=Math.max(count,end-start+1);

            }
            return count;
        }
    }
