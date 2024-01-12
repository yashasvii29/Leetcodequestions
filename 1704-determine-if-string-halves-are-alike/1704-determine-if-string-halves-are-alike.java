class Solution {
    public boolean halvesAreAlike(String s) {
        // alike means same
        int n=s.length();
        int half=n/2;
        int i=0;
        int c1=0,c2=0;
        while(i<half){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E'|| ch=='I' || ch=='O' || ch=='U' ){
                c1++;
            }
            i++;
        }
        
        while(half<n){
            char ch=s.charAt(half);
            if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E'|| ch=='I' || ch=='O' || ch=='U' ){
                c2++;
            }
            half++;
        }
        if(c1==c2)
            return true;
        return false;
    }
}