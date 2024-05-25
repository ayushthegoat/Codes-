//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int shortestPath(vector<vector<int>> &grid, pair<int, int> source,
                     pair<int, int> destination) {
        // code here
        if (source == destination) {
        return 0;
    }

     int row = grid.size();
    int col = grid[0].size();
    queue<pair<int, pair<int, int>>> q;  // {dist, {row, col}}

    vector<vector<int>> dist(row, vector<int>(col, 1e9));
    dist[source.first][source.second] = 0;
    q.push({0, {source.first, source.second}});

    const vector<pair<int, int>> directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    while (!q.empty()) {
        auto it = q.front();
        q.pop();
        int dis = it.first;
        int r = it.second.first;
        int c = it.second.second;

        for (const auto &dir : directions) {
            int nrow = r + dir.first;
            int ncol = c + dir.second;

            if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && grid[nrow][ncol] == 1 &&
                dis + 1 < dist[nrow][ncol]) {
                dist[nrow][ncol] = 1 + dis;
                if (nrow == destination.first && ncol == destination.second) {
                    return dis + 1;
                }
                q.push({1 + dis, {nrow, ncol}});
            }
        }
    }
    return -1;
    }
};


//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid(n, vector<int>(m));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }

        pair<int, int> source, destination;
        cin >> source.first >> source.second;
        cin >> destination.first >> destination.second;
        Solution obj;
        cout << obj.shortestPath(grid, source, destination) << endl;
    }
}

// } Driver Code Ends