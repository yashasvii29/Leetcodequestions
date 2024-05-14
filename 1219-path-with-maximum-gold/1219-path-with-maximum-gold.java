class Solution {
    public int getMaximumGold(int[][] grid) {
  int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) { // If the cell has gold
                    maxGold = Math.max(maxGold, explore(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int explore(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: If out of bounds or cell has no gold
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        // Temporarily store the gold in the current cell
        int currentGold = grid[row][col];
        // Mark the current cell as visited
        grid[row][col] = 0;

        // Explore in all four directions (up, down, left, right)
        int maxGold = 0;
        maxGold = Math.max(maxGold, explore(grid, row - 1, col)); // Up
        maxGold = Math.max(maxGold, explore(grid, row + 1, col)); // Down
        maxGold = Math.max(maxGold, explore(grid, row, col - 1)); // Left
        maxGold = Math.max(maxGold, explore(grid, row, col + 1)); // Right

        // Restore the original gold in the current cell
        grid[row][col] = currentGold;

        // Return the maximum amount of gold collected from this cell onwards
        return maxGold + currentGold;
}
}