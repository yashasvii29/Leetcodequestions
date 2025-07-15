class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;

        // Remove leading 'L's....starting wale l ko remove krenge
        int i = 0;
        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        // Remove trailing 'R's ...ending wale r ko remove kremge
        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        // Count 'R' or 'L' in the remaining substring (i to j)
        for (int k = i; k <= j; k++) {
            // stationary ko ignore krenge
            char c = directions.charAt(k);
            if (c == 'L' || c == 'R') {
                collisions++;
            }
        }

        return collisions;
    }
}
