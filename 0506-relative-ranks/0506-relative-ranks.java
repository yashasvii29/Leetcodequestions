class Solution {
    public String[] findRelativeRanks(int[] score) {
       
           int n=score.length;
        int demo[]=new int[n];
        for(int i=0;i<n;i++){
            demo[i]=score[i];
        }
         String ans[]=new String[score.length];
        Arrays.sort(score);
        // StringBuilder sb=new StringBuilder(3);
        ArrayList<String> ls=new ArrayList<>();
        ls.add("Gold Medal");
        ls.add("Silver Medal");
         ls.add("Bronze Medal");
         if(n==1){
            ans[0]=ls.get(0);
         }
         else if(n==2){
            if(demo[0]>demo[1]){
                 ans[0]=ls.get(0);
                 ans[1]=ls.get(1);
            }
           else{
            ans[0]=ls.get(1);
            ans[1]=ls.get(0);
           }
            
         }
         else if(n==3){
            int y=0;
            for(int i=n-1;i>=0;i--){
                int val=score[i];
                for(int j=0;j<n;j++){
                    if(demo[j]==val){
                        ans[j]=ls.get(y++);
                    }
                }
            }
         }

       


        int j=0;
        int len=n-3; //2
        // len-1=1
        if(n>3){
            for(int i=n-1;i>=len;i--){
            int key=score[i];
            for(int p=0;p<n;p++){
                if(demo[p]==key){
                    ans[p]=ls.get(j++);
                }
            }
        }
        int win=4;
        for(int val=len-1;val>=0;val--){
            int sol=score[val];//4
            for(int p=0;p<n;p++){
                if(demo[p]==sol){
                    ans[p]=Integer.toString(win++);
                }
            }
        }
        }
        
        return ans;
    }
}