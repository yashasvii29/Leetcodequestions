class Solution {
    public int countValidWords(String sentence) {
        String[] arr = sentence.split(" "); // Split by one or more spaces
        int c = 0;

        for (String str : arr) {
            if (str.isEmpty()) {
                continue; // Skip empty strings
            }
            if (isValidWord(str)) {
                c++;
            }
        }
        return c;
    }

    private boolean isValidWord(String str) {
        int hyphenCount = 0;
        int punctuationCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                return false; // Digits are not allowed
            } else if (Character.isLowerCase(ch)) {
                continue; // Lowercase letters are fine
            } else if (ch == '-') {
                hyphenCount++;
                if (hyphenCount > 1) {
                    return false; // More than one hyphen is not allowed
                }
                // Hyphen must be surrounded by lowercase letters
                if (i == 0 || i == str.length() - 1 || !Character.isLowerCase(str.charAt(i - 1)) || !Character.isLowerCase(str.charAt(i + 1))) {
                    return false;
                }
            } else if (ch == '!' || ch == '.' || ch == ',') {
                punctuationCount++;
                if (punctuationCount > 1) {
                    return false; // More than one punctuation is not allowed
                }
                if (i != str.length() - 1) {
                    return false; // Punctuation must be at the end
                }
            } else {
                return false; // Any other characters are invalid
            }
        }
        return true;
    }
}
