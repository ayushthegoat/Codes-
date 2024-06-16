public class Solution {
     private int m, n;
    private int emptyCells;
    private int result = 0;
    private List<(int, int)> directions = new List<(int, int)> { (1, 0), (-1, 0), (0, 1), (0, -1) };
    
    private void Dfs(int[][] grid, int currCount, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }
        
        if (grid[i][j] == 2) {
            if (currCount == emptyCells) {
                result++;
            }
            return;
        }
        
        grid[i][j] = -1;
        foreach ((int dirRow, int dirCol) in directions) {
            int i_ = i + dirRow;
            int j_ = j + dirCol;
            Dfs(grid, currCount + 1, i_, j_);
        }
        grid[i][j] = 0;
    }
    
    public int UniquePathsIII(int[][] grid) {
        m = grid.Length;
        n = grid[0].Length;
        emptyCells = 0;
        result = 0;
        
        int start_x = 0;
        int start_y = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    emptyCells++;
                
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        
        emptyCells += 1; // walk over every non-obstacle square exactly once.
        int currCount = 0;
        
        Dfs(grid, currCount, start_x, start_y);
        
        return result;
    }
}
