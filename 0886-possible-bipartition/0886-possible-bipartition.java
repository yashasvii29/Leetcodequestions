


class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
         // Build adjacency list
        List<Integer>[] graph = new ArrayList[n + 1]; // 1-based indexing
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<BipartitePair> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) { // loop from 1 to n (1-based)
            if (visited.containsKey(i)) {
                continue;
            }
            q.add(new BipartitePair(i, 0));
            while (!q.isEmpty()) {
                BipartitePair rp = q.poll();
                if (visited.containsKey(rp.vtx)) {
                    if (visited.get(rp.vtx) != rp.dis) {
                        return false;
                    }
                    continue;
                }
                visited.put(rp.vtx, rp.dis);
                for (int nbrs : graph[rp.vtx]) {
                    if (!visited.containsKey(nbrs)) {
                        q.add(new BipartitePair(nbrs, rp.dis + 1));
                    }
                }
            }
        }

        return true;
    }
}

class BipartitePair {
    int vtx;
    int dis;
    public BipartitePair(int vtx, int dis) {
        this.vtx = vtx;
        this.dis = dis;
    }
}
   


