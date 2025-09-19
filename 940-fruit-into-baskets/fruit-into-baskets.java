class Solution {
    public int totalFruit(int[] fruits) {
        int start=0;
        Map<Integer,Integer> basket=new HashMap<>();
        int count=0;
        for(int end=0;end<fruits.length;end++){
            
            basket.put(fruits[end],basket.getOrDefault(fruits[end],0)+1);
        
            while( basket.size()>2){
             basket.put(fruits[start],basket.get(fruits[start])-1);
             if(basket.get( fruits[start])==0){
                basket.remove( fruits[start]);

             }
             start++;
            }
            count =Math.max(count,end -start+1);
        }
         return count;
    }
}