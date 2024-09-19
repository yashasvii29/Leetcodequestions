class Solution {
    public String largestPalindromic(String num) {
         HashMap<Character, Integer> map = new HashMap<>();
        
        // Count frequency of each digit
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Create a sorted list of digits in descending order
        char[] arr = new char[map.size()];
        int idx = 0;
        for (char key : map.keySet()) {
            arr[idx++] = key;
        }
        Arrays.sort(arr);
        if(arr.length==1 && arr[0]=='0'){
            return "0";
        }

        // Building the largest palindrome
        StringBuilder sb = new StringBuilder();
        Character middle = null;
// char ka use nhi kr sakte because char is a primitive datatype h and it cannot be null
// that's why we hav eused Character

        // Build the first half of the palindrome
        for (int i = arr.length - 1; i >= 0; i--) {
            char key = arr[i];
            int count = map.get(key);

            // If there's an odd count, pick it as a middle char
            if (count % 2 == 1 && middle == null) {
                middle = key;
            }

            // Add even occurrences of the digit to the result
             for (int j = 0; j < count / 2; j++) {
                // Avoid leading zeros in the first half
                if (!(sb.length() == 0 && key == '0')) {
                    sb.append(key);
                }
            }
        }

        // Build the second half by reversing the first half
        StringBuilder reverse = new StringBuilder(sb).reverse();

        // Add middle char if available
        if (middle != null) {
            sb.append(middle);
        }

        // Combine the first half and the reversed half
        sb.append(reverse);

        return sb.toString();
    }
}