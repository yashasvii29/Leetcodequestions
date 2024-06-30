class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
            UnionFind ufA = new UnionFind(n);
        UnionFind ufB = new UnionFind(n);
        int edgesUsed = 0;
        
        // First, add all type 3 edges to both Alice and Bob's union find structures
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufA.union(edge[1] - 1, edge[2] - 1)) {
                    ufB.union(edge[1] - 1, edge[2] - 1);
                    edgesUsed++;
                }
            }
        }
        
        // Then, add type 1 edges to Alice's union find structure
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufA.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }
        
        // Finally, add type 2 edges to Bob's union find structure
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufB.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }
        
        // Check if both Alice and Bob can traverse the entire graph
        if (ufA.getCount() != 1 || ufB.getCount() != 1) {
            return -1;
        }
        
        // The maximum number of edges we can remove
        return edges.length - edgesUsed;
    }
    
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }

        public int getCount() {
            return count;
        }
    }
}