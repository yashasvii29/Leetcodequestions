class Solution {
    public String countAndSay(int n) {

        if(n==1){
            return "1";
        }
          String str = "1"; // Start with the base case

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 0; j < str.length()-1; j++) {
                if (str.charAt(j) == str.charAt(j + 1)) {
                    count++; // Increment count for consecutive characters
                } else {
                    sb.append(count).append(str.charAt(j)); // Append count and character
                    count = 1; // Reset count
                }
            }

            // Append the last group
            sb.append(count).append(str.charAt(str.length() - 1));
            str = sb.toString(); // Update str for the next iteration
        }

        return str;
    }
}