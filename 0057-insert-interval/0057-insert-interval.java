class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
          List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals that come before the newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge intervals that overlap with the newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals that come after the newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list back to an array
        return result.toArray(new int[result.size()][]);
    
    }
}