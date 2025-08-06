class MedianFinder {
 int ls,rs;
 PriorityQueue<Integer> left;
 PriorityQueue<Integer> right;
    public MedianFinder() {
       ls=rs=0;
       left=new PriorityQueue<>(Collections.reverseOrder());
       right= new PriorityQueue<>();
    
    }
    
    public void addNum(int num) {
      if(!right.isEmpty() && num > right.peek()){
        right.add(num);
        rs++;
        if(rs>ls){
            left.add(right.poll());
            rs--;
            ls++;
        }
      }
      else {
        left.add(num);
        ls++;
        if(ls-rs >1){
            right.add(left.poll());
            ls--;
            rs++;
        }
      }
    }
    
    public double findMedian() {
        if((ls+rs)%2==0)
        return  (left.peek() + right.peek())/2.0;
        return left.peek();
    }
}
 
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */