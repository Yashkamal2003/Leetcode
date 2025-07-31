class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int fuelLeft=startFuel;
        int stops=0;
        int prevPosition=0;
        for( int[] station:stations)
        {
            fuelLeft-=(station[0]- prevPosition);
            while(fuelLeft<0){
                if(pq.isEmpty())
                return -1;
                fuelLeft +=pq.poll();
                stops ++;

            }
            pq.add(station[1]);
            prevPosition=station[0];

        }
     fuelLeft-= ( target-prevPosition);
     while(fuelLeft<0){
        if(pq.isEmpty())
        return -1;
        fuelLeft += pq.poll();
        stops ++;
     }












        return stops;
    }
}