class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<products.length;i++){
         
            for(int j=i+1;j<products.length;j++){
              
                if(products[i].compareTo(products[j])>0){
                    String temp=products[i];
                    products[i]=products[j];
                    products[j]=temp;
                }
            }
        }


        for(int i=0;i<searchWord.length();i++){
            String pre=searchWord.substring(0,i+1);
            int c=0;
            List<String> ll=new ArrayList<>();
            for(int j=0;j<products.length;j++){
                if(products[j].startsWith(pre) && c<3){
                    ll.add(products[j]);
                    c++;
                }
            }
            ans.add(new ArrayList<>(ll));
        }
        return ans;
    }
}