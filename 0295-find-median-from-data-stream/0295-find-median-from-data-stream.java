class MedianFinder {
    // tc O(nlogn)
     PriorityQueue<Integer> min ;
     PriorityQueue<Integer> max ;

    public MedianFinder() {
        min =new PriorityQueue<>(); // min heap
        max =new PriorityQueue<>(Collections.reverseOrder()); // maxheap
    }
    
    public void addNum(int num) {
        if(min.size()==0 && max.size()==0){
            max.add(num);
        }
        else{
            if(max.peek()<num){
                min.add(num);
            }
            else{
                max.add(num);
            }
            
        }

           int m =min.size();
        int n= max.size();

        if((n-m==2) || (n-m==-2)){
            if(n>m){
                int ele = max.peek();
                max.poll();
                min.add(ele);
            }
            else{
                int ele = min.peek();
                min.poll();
                max.add(ele);
            }
        }
        
    }
    
    public double findMedian() {
        int m =min.size();
        int n= max.size();

        // if((n-m==2) || (n-m==-2)){
        //     if(n>m){
        //         int ele = max.peek();
        //         max.poll();
        //         min.add(ele);
        //     }
        //     else{
        //         int ele = min.peek();
        //         min.poll();
        //         max.add(ele);
        //     }
        // }
    
        if((n+m)%2 == 0){
           return ((double)max.peek()+(double)min.peek())/2.0;
        }
        if(n>m){
            return max.peek();
        }
         return min.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */