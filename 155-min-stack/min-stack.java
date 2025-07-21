class MinStack {
  long minElement;
  List<Long> lst;
  int size;
    public MinStack() {
        lst= new ArrayList<>();
        size=0;
        minElement= Integer.MAX_VALUE +1L;
    }
    
    public void push(int val) {
     long toBePushed=val;
     if(val<minElement){
        toBePushed=2*(long)val- minElement;
        minElement=val;

     }
      lst.add(toBePushed);
      size++;
    }
     
    public void pop() {
        long element=lst.get(size-1);
        if(element< minElement)
        minElement =2*(long)minElement-element;
     lst.remove(size-1);
     size--;
    }
    public int top() {
        long element=lst.get(size-1);
        if(element< minElement)
     
        element=minElement;
        return (int)element;
    }
    
    public int getMin() {
        return (int )minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */