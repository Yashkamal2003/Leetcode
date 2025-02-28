class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result= new ArrayList<>();
        int rows= matrix.length;
        int cols=matrix[0].length;
        int count=0;
        int up=0;
        int down= rows-1;
        int left=0;
         int right = cols-1;

        while(count <(rows* cols)){
            // for left to right
            for( int col= left; col<= right;col++){
                result.add(matrix[up][col]);
                count++;
            }
            // fror up to down
            for( int row= up+1; row<=down;row++){
                result.add(matrix[row][ right]);
                count++;
            }
            // for right to left 
             if ( up !=down)
            for (int col= right-1;col>= left;col--){
                result.add( matrix[down][ col]);
                count++;
            }
            // for down to up
            if( left != right)
            for( int row= down-1;row> up;row--){
                result.add( matrix[row ][left]);
                count++;
            }
            up++;
            down--; 
            left++; 
            right--;

        }
         return result;
    }
}