//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int shortestDistance(int N, int M, vector<vector<int>> A, int X, int Y) {
        
        // code here
        if (A[0][0] == 0 || A[X][Y] == 0) {
            return -1;
        }
        const vector<pair<int,int>> directions= {
            {1,0},{0,1},{-1,0},{0,-1}
        };
         priority_queue< pair<int, pair<int,int>>, vector< pair<int, pair<int,int>> >, greater<pair<int, pair<int,int>>>> pq;
        
        vector<vector<int>>dist(N,vector<int>(M,INT_MAX));
        dist[0][0] = 0;
        pq.push({0,{0,0}});
        
        
        while(!pq.empty()){
            auto it = pq.top();
            pq.pop();
            int currdist = it.first;
            int row = it.second.first;
            int col = it.second.second;
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
                if(nrow>=0 && nrow<N && ncol>=0 && ncol<M && A[nrow][ncol]==1){
                    if(currdist + 1 < dist[nrow][ncol]){
                        dist[nrow][ncol] = currdist + 1;
                        pq.push({dist[nrow][ncol],{nrow,ncol}});
                    }
                }
            }
        }
        if(dist[X][Y]==INT_MAX)return -1;
        return dist[X][Y];
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M, x, y;
        cin >> N >> M;
        vector<vector<int>> v(N, vector<int>(M));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) cin >> v[i][j];
        cin >> x >> y;
        Solution ob;
        cout << ob.shortestDistance(N, M, v, x, y) << "\n";
    }
}
// } Driver Code Ends