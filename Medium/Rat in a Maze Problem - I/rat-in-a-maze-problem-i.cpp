//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution{
    public:
    
    const vector<pair<int, int>> directions = {
        {1,0},{0,-1},{0,1},{-1,0}
    };
    
    bool isSafe(int i, int j, vector<vector<int>> &m, vector<vector<bool>> vis) {
        if(i>=0 && i<m.size() && j>=0 && j<m.size() && !vis[i][j] && m[i][j] == 1)return true;
        
        
        return false;
    }
    void findPaths(int i, int j,vector<vector<int>> &m, vector<vector<bool>> vis, string& path,vector<string>& paths) {
        int N = m.size();
        
        if( i == N-1 && j == N-1) {
            paths.push_back(path);
            return;
        }
        
        vis[i][j] = true;
        
        string  pathStr = "DLRU";
        
        
        for(int ctr = 0;ctr<4;ctr++) {
            int nrow = i + directions[ctr].first;
            int ncol = j + directions[ctr].second;
            
            if(isSafe(nrow, ncol, m, vis)) {
                path.push_back(pathStr[ctr]);
                findPaths(nrow, ncol, m, vis, path, paths);
                path.pop_back();
            }
        }
        
        vis[i][j] = false;
        
    }
    vector<string> findPath(vector<vector<int>> &m, int n) {
        // Your code goes here
        int N = m.size();
        vector<string>paths;
        vector<vector<bool>> vis(N, vector<bool>(N, false));
        string path = "";
        if (m[0][0] == 1) {
          findPaths(0, 0, m, vis, path, paths);
        }

        if (paths.empty()) {
          return {"-1"};
        }

        sort(paths.begin(), paths.end());
        return paths;
           
    }
};

    


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int> (n,0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m, n);
        sort(result.begin(), result.end());
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++) cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends