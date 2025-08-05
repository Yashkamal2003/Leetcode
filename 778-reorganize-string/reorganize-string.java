class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> freq= new HashMap<>();
        for(char ch:s.toCharArray())
        freq.put(ch,freq.getOrDefault(ch,0)+1);
        PriorityQueue<Character>pq= new PriorityQueue<>(
            (ch1,ch2)-> freq.get(ch2)-freq.get(ch1)
        );
        for (Map.Entry<Character,Integer> entry: freq.entrySet())
        pq.add(entry.getKey());
        String ans= "";
        for(int i =0;i<s.length();i++){
            char ch=pq.poll();
            if(i==0|| ans.charAt(i-1)!=ch){
                ans += ch;
                freq.put(ch, freq.get(ch)-1);
            }  else{
                if(pq.isEmpty())
                return "";
                char nextChar=pq.poll();
                ans+= nextChar;
                freq.put(nextChar,freq.get(nextChar)-1);
                if(freq.get(nextChar)>0)
                pq.add(nextChar);
            } if (freq.get(ch)>0)
            pq.add(ch);
        }
        return ans;
    }
}