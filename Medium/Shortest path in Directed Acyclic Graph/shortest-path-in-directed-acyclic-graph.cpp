//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution { 
 private: 
     void topological(int node, vector<int>& vis, vector<pair<int, int>> adj[], stack<int>& stk) {
         vis[node] = 1;
         for (auto it : adj[node]) {
             int v = it.first;
             if (!vis[v]) {
                 topological(v, vis, adj, stk);
             }
         }
         stk.push(node);
     }
  public:
     vector<int> shortestPath(int N, int M, vector<vector<int>>& edges) {
        vector<pair<int, int>> adj[N];
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj[u].push_back({v, wt});
        }
        
        vector<int> vis(N, 0);
        stack<int> stk;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topological(i, vis, adj, stk);
            }
        }
        
        vector<int> dist(N, INT_MAX);
        dist[0] = 0; // Assuming the source node is 0
        while (!stk.empty()) {
            int node = stk.top();
            stk.pop();
            
            if (dist[node] != INT_MAX) { // Only process nodes that have been reached
                for (auto it : adj[node]) {
                    int v = it.first;
                    int wt = it.second;
                    
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == INT_MAX) {
                dist[i] = -1;
            }
        }
        return dist;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> edges;
        for(int i=0; i<m; ++i){
            vector<int> temp;
            for(int j=0; j<3; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }
        Solution obj;
        vector<int> res = obj.shortestPath(n, m, edges);
        for (auto x : res) {
            cout << x << " ";
        }
        cout << "\n";
    }
}

// } Driver Code Ends