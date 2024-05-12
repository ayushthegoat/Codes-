//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
 private:
    void bfs(int startRow, int startCol, vector<vector<int>>& vis, vector<vector<char>>& grid) {
        vis[startRow][startCol] = 1;
        queue<pair<int, int>> q;
        q.push({startRow, startCol});
        
        while (!q.empty()) {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();
            
            // Define all 8 directions
            static const vector<pair<int, int>> directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
            };

            for (const auto& dir : directions) {
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                if (nrow >= 0 && nrow < grid.size() && ncol >= 0 && ncol < grid[0].size() &&
                    grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        
                    vis[nrow][ncol] = 1;
                    q.push({nrow, ncol});
                }
            }
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int cnt = 0;
        vector<vector<int>> vis(grid.size(), vector<int>(grid[0].size(), 0));
        
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}
// } Driver Code Ends