class Solution {
public:
    const vector<pair<int, int>> directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int dfs(vector<vector<int>>& grid, vector<vector<int>>& vis, int i, int j,
            int row, int col) {
        vis[i][j] = 1;
        int count = 1; // Count the current cell

        for (const auto& iterator : directions) {
            int nrow = i + iterator.first;
            int ncol = j + iterator.second;

            if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col &&
                !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                count += dfs(grid, vis, nrow, ncol, row, col);
            }
        }
        return count;
    }

    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int mx = 0;
        vector<vector<int>> vis(n, vector<int>(m, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 &&
                    !vis[i][j]) { // Only start DFS if it's a land cell and not
                                  // visited
                    int curr = dfs(grid, vis, i, j, n, m);
                    mx = max(mx, curr);
                }
            }
        }
        return mx;
    }
};