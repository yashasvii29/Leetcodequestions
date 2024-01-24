class Solution {
    public List<Integer> getRow(int rowIndex) {
         return PascalTriangle(rowIndex);
    }
    public static List<Integer> PascalTriangle(int num)
    {
        int row=0,star=0;
        List<Integer> ans=new ArrayList<>();
        while(row<=num)
        {
            int i=0;
            int ncr=1;
           if(row==num)
           {
               while(i<=star)
              {
                ans.add(ncr);
                ncr = (int)((row - i) * (long)ncr / (i + 1));
                // ncr=((row-i)*ncr)/(i+1);
                i++;    
              }
           }
           star++;
           row++;
           
        }
        return ans;
    }
}