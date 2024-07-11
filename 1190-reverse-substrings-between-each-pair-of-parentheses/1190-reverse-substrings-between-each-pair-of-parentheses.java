class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){ // innermost closed bracket
                String temp=""; // innermost bracket ke andar ki string ko reverse krenge
                while(st.peek()!='('){ 
                    temp+=st.peek();
                    st.pop();
                }
                st.pop(); // innermost open bracket ko pop krenge

                // again push reverse string temp in stack
                for(char c:temp.toCharArray()){
                    st.push(c);
                }
            }
            else{
                st.push(ch);
            }
        }
        String ans="";
        while(!st.isEmpty()){
            ans+=st.peek();
            st.pop();
        }
        
      String str="";
      for(int i=ans.length()-1;i>=0;i--){
        str+=ans.charAt(i);
      }


      return str;
    }
}