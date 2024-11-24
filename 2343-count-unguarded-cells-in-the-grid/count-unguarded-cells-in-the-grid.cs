public class Solution {
    public int CountUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[,] grid = new int[m, n];

        foreach(var guard in guards) {
            grid[guard[0], guard[1]] = 3;
        }

        foreach(var wall in walls) {
            grid[wall[0], wall[1]] = 2;
        }

        List<(int row, int col)> directions = new List<(int, int)> {
            (-1, 0),(1, 0),(0, -1),(0, 1)
        };

        foreach(var guard in guards) {
            int x = guard[0], y = guard[1];
            foreach(var(dx, dy) in directions) {
                Marker(x, y, dx, dy, grid, m, n);
            }
        }
         int unguardedCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i, j] == 0) { 
                        unguardedCount++;
                    }
                }
            }
        return unguardedCount;
    }
    private void Marker(int x, int y, int dx, int dy, int[,] grid, int m, int n) {
        int nx = x + dx;
        int ny = y + dy;
        while(nx >= 0 && ny >= 0 && nx < m && ny < n) {
            if(grid[nx, ny] == 3 || grid[nx, ny] == 2) break;

            if(grid[nx, ny] == 0) {
                grid[nx, ny] = 1;
            }
            nx += dx;
            ny += dy;
        }
    }
}