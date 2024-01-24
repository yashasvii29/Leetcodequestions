class Solution {
    public String largestNumber(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }
        }
        if(c==nums.length)
            return "0";
        return sort(nums);

    }
        public static String sort(int[] nums){
            for(int i=1;i<nums.length;i++){
            for(int j=0;j<nums.length-i;j++){
                if(compare(nums[j],nums[j+1])){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        String str="";
         for(int i=0;i<nums.length;i++){
             str+=nums[i];
         }
         
       
         return str;
    }
        
        
        public static boolean compare(int n,int m){
            String s=""+n+m;
            String s1=""+m+n;
            if(s1.compareTo(s)>=0)
                return true;
            return false;
        }
    // we sholud use compare method to comapre method to compare the strings
}