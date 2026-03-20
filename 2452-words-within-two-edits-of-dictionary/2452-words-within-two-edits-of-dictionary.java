class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
           List<String> result = new ArrayList<>();

        // Check each query word one by one
        for (String query : queries) {

            // Compare with every dictionary word
            for (String dict : dictionary) {
                int diff = 0; // count of different positions

                // Compare character by character
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != dict.charAt(i)) {
                        diff++; // position i is different = 1 edit needed
                    }
                    // Early exit: more than 2 diffs already → no point checking further
                    if (diff > 2) break;
                }

                // If at most 2 positions differ → query matches this dict word
                if (diff <= 2) {
                    result.add(query);
                    break; // no need to check other dict words for this query
                }
            }
        }
        return result;
    }
}