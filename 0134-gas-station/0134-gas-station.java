class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tc = 0;	
		for (int i = 0; i < cost.length; i++) {
			tc = tc + gas[i] - cost[i];
		}

		if (tc < 0) {
			return -1;
		}
		int si = 0;
		int curr = 0;
		for (int i = 0; i < cost.length; i++) {
			curr += gas[i] - cost[i];

			if (curr < 0) {
				curr = 0;
				si = i + 1;
			}
		}

		return si;
    }
}