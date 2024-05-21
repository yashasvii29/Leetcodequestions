class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
          PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
          for(int val:stones){
            pq.add(val);
          }
          while(pq.size()!=1){
            int a=pq.poll();
            int b=pq.poll();
            int diff=a-b;
            pq.add(diff);
          }
          return pq.peek();
    
    }
}