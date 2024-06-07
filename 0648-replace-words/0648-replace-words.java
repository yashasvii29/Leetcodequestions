class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
         // Insert all dictionary roots into a HashSet
        Set<String> rootSet = new HashSet<>(dictionary);

        // Replace words in the sentence
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, rootSet));
        }
        return result.toString();
    }

     // Method to find the shortest root for a given word
    public String findRoot(String word, Set<String> rootSet) {
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (rootSet.contains(prefix)) {
                return prefix;
            }
        }
        return word;  // No matching root found, return the original word
    }
}