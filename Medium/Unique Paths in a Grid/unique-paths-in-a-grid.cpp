//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int uniquePaths(int n, int m, vector<vector<int>> &grid) {
        // code here
        const int MOD = 1e9 + 7;
      
        if (grid[0][0] == 0 || grid[n-1][m-1] == 0) {
        return 0;
        }
        vector<pair<int, int>> directions = {{1,0},{0,1}};
        
        queue<pair<int,int>>q;
        q.push({0,0});
        vector<vector<int>> ways(n, vector<int>(m, 0));
        ways[0][0] = 1;
        
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int row = it.first;
            int col = it.second;
            
            for(const auto &dir : directions) {
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  grid[nrow][ncol]==1) {
                    if(ways[nrow][ncol] == 0){
                         q.push({nrow, ncol}); 
                    }
                    ways[nrow][ncol] = (ways[nrow][ncol] + ways[row][col]) % MOD;
                   
                }
            }
        }
        return ways[n-1][m-1];
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,m,x;
        cin>>n>>m;
        
        vector<vector<int>> grid(n,vector<int>(m));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cin>>grid[i][j];
            }
        }

        Solution ob;
        cout << ob.uniquePaths(n,m,grid) << endl;
    }
    return 0;
}
// } Driver Code Ends