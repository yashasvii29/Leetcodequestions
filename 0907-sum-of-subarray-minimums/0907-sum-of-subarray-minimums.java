class Solution {
    public int sumSubarrayMins(int[] arr) {
        // har subarray m se min element ko find krna hai and then add krna hai ...after that return the sum
    int nextSm[]=nextSmaller(arr);
     int prevSm[]=prevSmaller(arr);
    long c=0;
    int mod = 1000000007;
    for(int i=0;i<arr.length;i++){
        int first = i-prevSm[i];
        int second = nextSm[i]-i;
        long product = (first*second)%mod;
        product = (product*arr[i])%mod;
        c=(c%mod+product)%mod;
    }
        return (int)c;
    }

    private int[] nextSmaller(int arr[]){
        Stack<Integer> st = new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=arr.length;
            }
            else{
                ans[i]=st.peek();
            }
             st.push(i);
        }
        return ans;
       
    }

    private int[] prevSmaller(int arr[]){
        Stack<Integer> st = new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }

}







        // brute force => tc O(n2)
        // int n=nums.length;
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     ArrayList<Integer> ans=new ArrayList<>();
            
        //     ans.add(nums[i]);
        //     sum+=nums[i];
        //     for(int j=i+1;j<n;j++){
        //        ans.add(nums[j]);
        //        Collections.sort(ans);
        //         sum+=ans.get(0);
        //     }

        // }
        // return sum%1000000007;
