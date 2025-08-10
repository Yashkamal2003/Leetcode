

class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st= new Stack<>();
        int maxLength=0;
        st.push(-1);
        for( int i=0 ;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
           { st.push(i);}
            else{
                st.pop();
                if( st.isEmpty()){
                st.push(i);}
                else{
                maxLength=Math.max(maxLength, i-st.peek());
                    
                }
                
            }
        } 
        return maxLength;
    }
}