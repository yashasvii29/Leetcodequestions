class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
         int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        
        return backtrack(words, letterCount, score, 0);
    }
    
    private static int backtrack(String[] words, int[] letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        
        // Option 1: Skip the current word
        int maxScore = backtrack(words, letterCount, score, index + 1);
        
        // Option 2: Include the current word if possible
        String word = words[index];
        int wordScore = 0;
        boolean canFormWord = true;
        int[] wordLetterCount = new int[26];
        
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            wordLetterCount[charIndex]++;
            if (wordLetterCount[charIndex] > letterCount[charIndex]) {
                canFormWord = false;
            }
            wordScore += score[charIndex];
        }
        
        if (canFormWord) {
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']--;
            }
            maxScore = Math.max(maxScore, wordScore + backtrack(words, letterCount, score, index + 1));
            // backtrack kr rhe hai
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']++;
            }
        }
        
        return maxScore;
    }
}