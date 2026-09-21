class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int minCoins[][]= new int[n+1][amount+1];
       ;
        for(int i=0;i<=n;i++)
        for( int remAmount=0;remAmount <=amount;remAmount++){
            if(remAmount==0)
            minCoins[i][remAmount]=0;
            else if(i==0)
            minCoins[i][remAmount]=amount+1;
            else{
                int donTake=minCoins[i-1][remAmount];
                int take= amount+1;
                if(remAmount>=coins[i-1])
                take=1+minCoins[i][remAmount-coins[i-1]];
                minCoins[i][remAmount]=Math.min(take,donTake);
            }
        }
        if(minCoins[n][amount]>amount)
        minCoins[n][amount]=-1;
        return minCoins[n][amount];
        
    }
}