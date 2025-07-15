class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        int ans = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long firstSum = prefix[i];
            long firstAvg = firstSum / (i + 1);

            long secondSum = sum - firstSum;
            long secondAvg = (i == n - 1) ? 0 : secondSum / (n - i - 1);

            long diff = Math.abs(firstAvg - secondAvg);

            if (diff < min) {
                min = diff;
                ans = i;
            }
        }

        return ans;
    }
}
