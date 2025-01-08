class Solution {
    public int countPrefixSuffixPairs(String[] words) {
//         startsWith and endsWith:
// These methods are used to check if one string is a prefix or suffix of another string.
        int c=0;
          for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
               if (i != j && words[j].length()>=words[i].length()) {
                    // Check if words[i] is a prefix or suffix of words[j]
                    if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}