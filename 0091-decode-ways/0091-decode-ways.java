class Solution {
    public int numDecodings(String s) {
        int n =s.length();
        int next1=1;//dp[i+1]
        int next2=0;//dp[i+2]
        // int dp[]=new int[n +1];
        // dp[n]=1;
        for(int i =n-1;i>=0;i--){
            int ans=0;//dp[i]
            //first char is 0
            if(s.charAt(i)=='0'){
            ans=0;}
            else{ 
                 int takeOneDigit =next1;
                 int takeTwoDigits=0;
                 if(i<=(n-2)){
                    int no=(s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                    if(no<=26)
                    takeTwoDigits=next2;
                 }
                 ans= takeOneDigit +takeTwoDigits;
            }
            next2=next1;
            next1=ans;
        }
        return next1;

    }
}