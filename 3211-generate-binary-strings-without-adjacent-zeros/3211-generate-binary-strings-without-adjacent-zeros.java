class Solution {
    public List<String> validStrings(int n) {
        List<String> ll=new ArrayList<>();
         PrintOutcomes(n,ll,"");
         return ll;
    }
    public static void PrintOutcomes(int n,List<String> ll,String ans){
         if(n==0)
         {
            ll.add(ans);
            return;
            
         }
        
         if(ans.length()==0 || ans.charAt(ans.length()-1)!='0'){
            PrintOutcomes(n-1,ll, ans+"0");
            
         }
         
         PrintOutcomes(n-1,ll, ans+"1");
        
 
     }
}