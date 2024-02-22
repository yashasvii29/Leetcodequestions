class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        int count[]=new int[n+1];
    
        for(int i=0;i<trust.length;i++){
            set.add(trust[i][0]);
            count[trust[i][1]]++;
               
            }
        for(int i=1;i<=n;i++){
            if(!set.contains(i) && count[i]==n-1){
                return i;
            }
            
        }
     return -1;
    }
}