//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
    typedef pair<int,int> pii;
public:
    int findShortestPath(vector<vector<int>> &mat)
    {
       // code here
        int n = mat.size();
        if (n == 0) return -1;
        int m = mat[0].size();
        if (m == 0) return -1;

        vector<vector<int>> vis(n, vector<int>(m, 0));
        vector<vector<int>> temp = mat;
        queue<pair<int, pii>> q;
        const vector<pii> directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        // Mark all adjacent cells of landmines as unsafe
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (const auto &dir : directions) {
                        int nrow = i + dir.first;
                        int ncol = j + dir.second;

                        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m)
                            temp[nrow][ncol] = 0;
                    }
                }
            }
        }

        // Initialize the queue with the safe cells in the leftmost column
        for (int i = 0; i < n; i++) {
            if (temp[i][0] == 1) {
                q.push({1, {i, 0}});
                vis[i][0] = 1;
            }
        }

        // Perform BFS
        while (!q.empty()) {
            auto it = q.front();
            q.pop();
            int currDist = it.first;
            int row = it.second.first;
            int col = it.second.second;

            if (col == m - 1) return currDist;

            for (const auto &dir : directions) {
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    temp[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.push({currDist + 1, {nrow, ncol}});
                }
            }
        }
        return -1;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int R, C;
        cin >> R >> C;
        vector<vector<int>> mat(R, vector<int>(C));
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                cin >> mat[i][j];
            }
        }

        Solution ob;
        int ans = ob.findShortestPath(mat);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends