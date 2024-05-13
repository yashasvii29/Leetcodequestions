class Solution {
    public int matrixScore(int[][] grid) {
      int m = grid.length;
        int n = grid[0].length;
        
        // Toggle rows to ensure the leftmost bit of each row is 1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        // Toggle columns to ensure each column has more 1s than 0s
        for (int j = 1; j < n; j++) {
            int count_1 = 0;
            for (int i = 0; i < m; i++) {
                count_1 += grid[i][j];
            }
            if (count_1 < m - count_1) {

                for (int i = 0; i < m; i++) {
                    // y toggling ka logic h in col
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        // Calculate the score
        int score = 0;
        for (int i = 0; i < m; i++) {
            // binaryToDecimal fun m row bhej rhe h to calculate the score
            score += binaryToDecimal(grid[i]);
        }
        
        return score;
    }
    
    private int binaryToDecimal(int[] binary) {
         // Convert array to string
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < binary.length; i++) {
//             sb.append(binary[i]);
//         }
//         String str = sb.toString();
//        Long n=Long.parseLong(str);
//         int mul=1;
//         long ans=0;
//         while(n>0){
//             long rem=n%10;
//             ans=(long)ans+rem*mul;
//             mul=mul*2;
//             n=n/10;
//         }
//         return (int)ans;
        
        
         int decimal = 0;
    int power = binary.length - 1;
    for (int bit : binary) {
        decimal += bit * Math.pow(2, power);
        power--;
    }
    return decimal;
      
       
    }
}