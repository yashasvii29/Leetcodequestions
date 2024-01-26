import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> result = new ArrayList<>();

        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() < s2.length()) {
            return result;
        }

        int[] frequencyS2 = new int[26]; // Assuming lowercase English letters

        // Populate frequency map for s2
        for (char ch : s2.toCharArray()) {
            frequencyS2[ch - 'a']++;
        }

        int[] frequencyWindow = new int[26];

        // Initialize the frequency map for the first window
        for (int i = 0; i < s2.length(); i++) {
            frequencyWindow[s1.charAt(i) - 'a']++;
        }

        // Check the anagram for the first window
        if (matches(frequencyS2, frequencyWindow)) {
            result.add(0);
        }

        // Slide the window and check anagrams
        for (int i = s2.length(); i < s1.length(); i++) {
            frequencyWindow[s1.charAt(i - s2.length()) - 'a']--; // Remove the leftmost character
            frequencyWindow[s1.charAt(i) - 'a']++; // Add the new character

            if (matches(frequencyS2, frequencyWindow)) {
                result.add(i - s2.length() + 1);
            }
        }

        return result;
    }

    private boolean matches(int[] frequencyS2, int[] frequencyWindow) {
        for (int i = 0; i < 26; i++) {
            if (frequencyS2[i] != frequencyWindow[i]) {
                return false;
            }
        }
        return true;
    }
}
