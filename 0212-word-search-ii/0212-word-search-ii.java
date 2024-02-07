class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        ll=new ArrayList<>();
        Node root = new Node();
        for(String s:words){
            // trie m words array ki string ko add kr rhe hai
            insert(root,s);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.child.containsKey(board[i][j])){
                    wordsearch(board,i,j,root);
                }
            }
        }
        return ll;
    }

     static class Node{
        char data;
        String isTerminal = null;
        HashMap<Character,Node> child = new HashMap<>();
    }
    public static void insert(Node root,String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
            }
            else{
                Node nn = new Node();
                nn.data=ch;
                curr.child.put(ch,nn);
                curr= nn;
            }
        }
        curr.isTerminal=word;
    }
    // public static boolean search(String word) {
    //     Node curr = root;
    //     for(int i=0;i<word.length();i++){
    //         char ch=word.charAt(i);
    //         if(curr.child.containsKey(ch)){
    //             curr=curr.child.get(ch);
    //         }
    //         else{
    //           return false;
    //         }
    //     }
    //         return curr.isTerminal;
    // }
    // public boolean startsWith(String prefix) {
    //     Node curr = root;
    //    for(int i=0;i<prefix.length();i++){
    //        char ch=word.charAt(i);
    //        if(curr.child.containsKey(ch)){
    //            curr=curr.child.get(ch);
    //        }
    //        else{
    //          return false;
    //        }
    //    }
    //        return true;
    //  }
    
   static  List<String> ll=new ArrayList<>();
    public static void wordsearch(char[][] board,int r,int c,Node root){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || !root.child.containsKey(board[r][c])){
            return ;
        }
        char ch = board[r][c];
        Node curr = root.child.get(ch);
        if(curr.isTerminal!=null){
            ll.add(curr.isTerminal);
            curr.isTerminal=null;
        }
        board[r][c]='*';
        wordsearch(board,r+1,c,curr);
        wordsearch(board,r-1,c,curr);
        wordsearch(board,r,c+1,curr);
        wordsearch(board,r,c-1,curr);
        board[r][c]=ch;
    }
       
    }
        // recursion and backtracking se tle aa rha hai
    // so we will use trie
    // words array se trie banayenge and uss trie ki help se time complexity kam ho jayegi

    














  //     List<String> list=new ArrayList<>();
    //         boolean ans=false;
    //         for(int k=0;k<words.length;k++){
    //         for(int i=0;i<board.length;i++){
    //             for(int j=0;j<board[0].length;j++){
    //                 ans=WordSearch(board,i,j,words[k],0);
    //                 if(ans){
    //                     list.add(words[k]);
    //                     break;
    //                 }
    //             }
    //             if(ans)
    //                break;
    //         }
    //     }
    //     return list;
    // }
    // public static boolean WordSearch(char board[][],int r,int c,String word,int idx){
    //     if(idx==word.length()){
    //         return true;
    //     }
    // if(r<0 ||r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(idx)){
    //         return false;
    //     }
    //     int row[]={1,0,0,-1};
    //     int col[]={0,1,-1,0};
    //     boolean ans=false;
    //     board[r][c]='*';
    //     for(int i=0;i<col.length;i++){
    //          ans=WordSearch(board,r+row[i],c+col[i],word,idx+1);
    //         if(ans){
    //             board[r][c]=word.charAt(idx);// condtion ke andar bhi isliye undo kr rhe hai kyunki words array m bahut sari string hai
    //             // word search que m nhi kiya tha because word string thi but word search2nd m word array hai which contain strings
    //             return ans;
    //         }
    //     }
    //     board[r][c]=word.charAt(idx);
    //   