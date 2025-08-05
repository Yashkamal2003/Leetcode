class Solution {
    public int leastInterval(char[] tasks, int n) {
        //CALCULTAE THE FREQ
        int freq[]= new int [26]; 
        for(char ch: tasks)
        freq[ch-'A']++;
        // creatwe a max heap sorted on freq
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<26;i++)
        if(freq[i]>0)
        pq.add(freq[i]);
        int time=0;
        while(!pq.isEmpty()){
            int cycleLength=n+1;
            List<Integer> temp= new ArrayList<>();
            int taskCount=0;
            while(cycleLength --> 0 && !pq.isEmpty()){
                int currentMaxFreq=pq.poll();
                if(currentMaxFreq>1)
                temp.add(currentMaxFreq-1);
                taskCount++;
            }
             for(int f:temp)
             pq.add(f);
             time +=((pq.isEmpty())? taskCount : (n+1));
        }




        
         return time;
    }
}