class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {


//         Find ALL paths from node 0 to last node (n-1)

// graph = [[1,2],[3],[3],[]]
// Node 0 → can go to [1, 2]
// Node 1 → can go to [3]
// Node 2 → can go to [3]
// Node 3 → can go to [] (destination)

// Output: [[0,1,3], [0,2,3]]

         List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }
    
    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path)); // Found complete path
            return;
        }
        for (int neighbor : graph[node]) {
            // graph[0] = [1,2]...0 ke neighbour hai 1 and 2  so pehle neighbour m 1 jayega then 2 
            path.add(neighbor);
            dfs(graph, neighbor, path, result);
            path.remove(path.size() - 1); // Backtrack
        }
    }
}

// DFS  → explores ALL possible paths ✅

// Backtrack → after exploring one path
//             UNDO last step
//             try another path


// For each neighbor of current node:
// 1. ADD neighbor to path
// 2. DFS deeper from neighbor
// 3. REMOVE neighbor after returning (backtrack)
//    → undo step so we can try next neighbor

// [0]         ← start
// [0,1]       ← add 1
// [0,1,3]     ← add 3, FOUND PATH ✅ save it
// [0,1]       ← remove 3 (backtrack)
// [0]         ← remove 1 (backtrack)
// [0,2]       ← add 2
// [0,2,3]     ← add 3, FOUND PATH ✅ save it
// [0,2]       ← remove 3 (backtrack)
// [0]         ← remove 2 (backtrack)
// DONE