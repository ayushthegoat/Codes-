class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
       

        int n = grid.size();
        int m = grid[0].size();

        vector<vector<int>> vis(n, vector<int>(m,0)); 
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if (grid[0][0] == 0 && grid.size() == 1) return 1;
        queue<pair<int, pair<int, int>>> q;
        q.push({1, {0, 0}});
        vis[0][0] = 1;

        const vector<pair<int, int>> directions = {{1, 0},  {0, 1},   {-1, 0},
                                                   {0, -1}, {-1, -1}, {-1, 1},
                                                   {1, -1}, {1, 1}};

        while (!q.empty()) {
            auto it = q.front();
            q.pop();
            int dist = it.first;
            int row = it.second.first;
            int col = it.second.second;

            for (const auto& dir : directions) {
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if (nrow == n - 1 && ncol == m - 1)
                    return dist+1;

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = 1;
                    
                    q.push({dist + 1, {nrow, ncol}});
                }
            }
        }
        return -1;
    }
};