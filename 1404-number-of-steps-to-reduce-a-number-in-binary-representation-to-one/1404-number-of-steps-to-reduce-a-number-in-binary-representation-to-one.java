class Solution {
    public int numSteps(String s) {
      int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        
        // Continue until the binary number is reduced to "1"
        while (!sb.toString().equals("1")) {
            int length = sb.length();
            if (sb.charAt(length - 1) == '0') {
                // If the number is even, divide by 2 (remove the last bit)
                sb.deleteCharAt(length - 1);
            } else {
                // If the number is odd, add 1
                int carry = 1;
                for (int i = length - 1; i >= 0; i--) {
                    if (sb.charAt(i) == '1') {
                        sb.setCharAt(i, '0');
                    } else {
                        sb.setCharAt(i, '1');
                        carry = 0;
                        break;
                    }
                }
                if (carry == 1) {
                    sb.insert(0, '1');
                }
            }
            steps++;
        }
        
        return steps;
    }
}