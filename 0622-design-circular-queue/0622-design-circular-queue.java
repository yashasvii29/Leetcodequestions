class MyCircularQueue {

    protected int arr[];
    protected int front=0;
    protected int top=0;
    public MyCircularQueue(int k) {
        arr=new int[k];
    }

      public boolean isEmpty() {
        return top == 0;
    }
    
    public boolean isFull() {
        return top == arr.length;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            // throw new Exception("Queue is full");
            return false;
        }
        int idx=(top+front)%arr.length; // index find krenge 
        // circular queue bana rhe h that's why %n krenge
        arr[idx]=value;
        top++;
        return true;
    }
    
    public boolean deQueue() {
         if(isEmpty()){
            // throw new Exception("Queue is Empty");
            return false;
        }
        int rv=arr[front]; //  remove value 
        // queue se value remove krne ke baad front ko increase krd denge
        front=(front+1)%arr.length;
        top--;
        return true;
    }
    
    public int Front() {
          if(isEmpty()){
        // throw new Exception("Queue is Empty"); 
        return -1;
       } 
       return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()){
        // throw new Exception("Queue is Empty"); 
        return -1;
       } 
       int idx = (front + top - 1) % arr.length;  // Calculate the correct rear index
        return arr[idx];
       
    }
    
  
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */