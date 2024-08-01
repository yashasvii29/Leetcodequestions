class Solution {
    public int countSeniors(String[] details) {
        int n=details.length;
        int c=0;
        for(int j=0;j<details.length;j++){
            c+=PrintSum(details[j]);
        }
        return c;
    }
    public static int PrintSum(String str){
        String k="";
            k=str.substring(11,13);
            int s=Integer.parseInt(k);
            if(s>60)
                return 1;  
            else
                return 0;
    }
}