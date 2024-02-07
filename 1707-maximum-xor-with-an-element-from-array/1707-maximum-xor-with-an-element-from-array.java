class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Pair p[] = new Pair[queries.length];
        for(int i=0;i<p.length;i++){
            p[i]=new Pair(queries[i][0],queries[i][1],i);
        }
        Arrays.sort(p,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1,Pair o2){
                return o1.mi-o2.mi;
            }
        });
        int ans[]=new int[p.length];
        int j=0;
        Node root = new Node();
        for(Pair x:p){
            while(j<nums.length && nums[j]<=x.mi){
                add(root,nums[j]);
                j++;
            }
            if(j==0){
                ans[x.i]=-1;
            }
            else{
                ans[x.i]=getxor(root,x.xi);
            }
        }
        return ans;
    }
    
        static class Node{
            Node zero;
            Node one;
        }
        public static void add(Node root,int val){
            Node curr = root;

            for(int i=31;i>=0;i--){
                int bit = (val & (1<<i));
                if(bit == 0){
                    if(curr.zero!=null){
                        curr=curr.zero;
                    }
                    else{
                        Node nn = new Node();
                        curr.zero=nn;
                        curr=nn;
                    }
                }
                else{
                    if(curr.one!=null){
                        curr=curr.one;
                    }
                    else{
                        Node nn = new Node();
                        curr.one=nn;
                        curr=nn;
                    }
                }
            }
        }
    
    public static int getxor(Node root,int val){
        Node curr=root;
        int xor=0;
        for(int i=31;i>=0;i--){
            int bit = (val & (1<<i));
            if(bit==0){
                if(curr.one!=null){
                    xor+=(1<<i);
                    curr=curr.one;
                }
                else{
                    curr=curr.zero;
                }
            }
            else{
                if(curr.zero!=null){
                    xor+=(1<<i);
                    curr=curr.zero;
                }
                else{
                    curr=curr.one;
                }
            }
        }
        return xor;
    }

     static class Pair{
        int xi,mi,i;
        public Pair(int xi,int mi,int i){
            this.xi=xi;
            this.mi=mi;
            this.i=i;

        }
    }
   
}


// har query ke corresponding max xor find krna hai
        // every query has two value [xi,mi] ...where xi denotes ki xi se xor  find krna hai and mi denotes the max value of the array jiske sath xor find krna hai if mi is 1 toh xi ka xor krenge with those values which is less than or equal to mi in the array
        // binary trie impllementation logic