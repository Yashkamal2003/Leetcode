class Solution {
    static int lcs(String s1, String s2) {
        // code herent n
        int n= s1.length();
        int m= s2.length();
        int [][] dp=new int[n+1][m+1];
        for( int i=1;i<=n;i++){
            for( int j=1;j<=m;j++) {
                dp[i][j]=-1;
            }
        }
        return  lcsutil(n,m,s1,s2,dp);
    }
    static int lcsutil( int n,int m,String s1, String s2,int[][]dp){
       
        if( n==0||m==0)
        return 0;
        if (dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1))
        return dp[n][m]=1+ lcsutil(n-1,m-1,s1,s2,dp);
        else  return dp[n][m]=Math.max(lcsutil(n-1,m,s1,s2,dp),lcsutil(n,m-1,s1,s2,dp));
    }
}