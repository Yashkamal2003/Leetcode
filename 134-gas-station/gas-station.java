class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int s=0;
        int d=0;
        int startStation=0;
        for( int i=0;i<n;i++)
        {
             s+=gas[i];
             if(s>= cost[i])
             s-= cost[i];
             else{
                d+=(cost[i] -s);
                s=0;
                startStation=i+1;
             }
        }
         if(s>=d)
          return startStation;
          return -1;
    }
}