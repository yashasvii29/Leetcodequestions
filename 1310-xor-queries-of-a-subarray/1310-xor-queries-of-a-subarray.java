class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int res[]=new int[queries.length];
       for(int i=0;i<queries.length;i++){
           int a =queries[i][0];
           int b=queries[i][1];
           if(a==b){
               res[i]=arr[a];
           }
           else if(a<b && Math.abs(a-b)!=1){
             int ans =arr[a];
               while(a!=b){
                   ans=ans^arr[a+1];
                  res[i]=ans;
                   a++;
               }
            //    res[i]=ans^arr[b];

           }
           else{
               res[i]=arr[a]^arr[b];
           }
            
       }
       return res;
    }
}