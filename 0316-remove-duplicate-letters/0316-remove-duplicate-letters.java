class Solution {
    public String removeDuplicateLetters(String s) {
        // monotonic stack means strictly increasing or decreasing
        // b-2,c-2,a-1
          // HashMap to count the occurrences of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Stack to maintain the result characters
        Stack<Character> stack = new Stack<>();
        // Set to keep track of characters already in the stack
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Decrease the count of the current character
            map.put(ch, map.get(ch) - 1);

            // If character is already in the stack, skip it
            if (seen.contains(ch)) continue;

            // Maintain the stack in lexicographical order
            while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) > 0) {
                seen.remove(stack.pop());
            }

            // Push current character to the stack and add to seen set
            stack.push(ch);
            seen.add(ch);
        }

        // Construct the result from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
        
    
}