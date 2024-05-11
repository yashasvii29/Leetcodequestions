class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
         int n = quality.length;
        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, (a, b) -> Double.compare((double) a.wage / a.quality, (double) b.wage / b.quality));

        double minCost = Double.MAX_VALUE;
        int workQuality = 0;
        PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> b - a);

        for (Worker worker : workers) {
            workQuality += worker.quality;
            res.offer(worker.quality);

            if (res.size() > k) {
                workQuality -= res.poll();
            }

            if (res.size() == k) {
                minCost = Math.min(minCost, workQuality * ((double) worker.wage / worker.quality));
            }
        }

        return minCost;
    }
}

class Worker {
    int quality;
    int wage;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }
}
