

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            // iss que m negative integer ke liye condition apply krenge
            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                int sum = a + st.peek();
                if (sum < 0) {
                    st.pop();
                } else if (sum > 0) {
                    a = 0;
                    break;
                } else { // sum == 0
                    st.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                st.push(a);
            }
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
