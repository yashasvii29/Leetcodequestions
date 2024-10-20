class MyCircularDeque {

    protected int arr[];
    protected int front=0;
    protected int rear=0;
    protected int top=0;
    
    public MyCircularDeque(int k) {
        arr = new int[k];
      
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + arr.length) % arr.length;  // Move front backwards
        arr[front] = value;
        top++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % arr.length;  // Move rear forwards
        top++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % arr.length;  // Move front forwards
        top--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + arr.length) % arr.length;  // Move rear backwards
        top--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + arr.length) % arr.length];  // Adjust rear to get the last element
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public boolean isFull() {
        return top == arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */