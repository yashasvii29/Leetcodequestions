class Solution {
    public String maximumOddBinaryNumber(String s) {
       
        int ones = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        char arr[] = new char[s.length()];
        Arrays.fill(arr, '0');
        for (int i = 0; i < ones - 1; i++) {
            arr[i] = '1';
        }
        // maximum odd binary number banane ke liye arr ke last index pr 1 assign kr denge
        arr[s.length() - 1] = '1';
        
        return new String(arr);
    }
}
