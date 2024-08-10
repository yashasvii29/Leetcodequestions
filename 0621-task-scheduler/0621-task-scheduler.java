class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }

        Arrays.sort(cnt);
        int max = cnt[25];
        int idle = (max - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max - 1, cnt[i]);
        }
        return tasks.length + Math.max(idle, 0);
    }
}