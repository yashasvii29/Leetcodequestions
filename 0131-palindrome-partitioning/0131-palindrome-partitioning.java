class Solution {
    public List<List<String>> partition(String s) {
        List<String> ll=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        Partioning(s, ll,ans);
        return ans;
    }
    public static void Partioning(String ques,List<String> ll,List<List<String>> ans){
        if(ques.length()==0){
            //System.out.println(ll);
            ans.add(new ArrayList<>(ll));
            return ;
        }
        for(int i=0;i<ques.length();i++){
            String part=ques.substring(0,i+1);
            if(isPalindrome(part)){
                ll.add(part);
                 Partioning(ques.substring(i+1),ll,ans);
                 ll.remove(ll.size()-1);
        }
     }
    }
     public static boolean isPalindrome(String check) {
        int i=0;
        int j=check.length()-1;
        while(i<j){
            if(check.charAt(i)!=check.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
     }
    

    }
