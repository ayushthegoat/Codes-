//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    bool dfs(int node, vector<int> adj[], int vis[], int pathVis[], int safe[]){
        vis[node] = 1;
        pathVis[node] = 1;
        safe[node] = 0;
        
        for(auto it : adj[node]){
            if(!vis[it]){
                if(dfs(it,adj,vis,pathVis,safe)){
                    safe[node] = 0;
                    return true;
                }
                
            }else if(pathVis[it]){
                    safe[node] = 0;
                    return true;
                }
        }
        pathVis[node] = 0;
        safe[node] = 1;
        return false;
        
        
           vis[node] = 1;        // Mark the node as visited
        pathVis[node] = 1;    // Mark the node as part of the current path
        
        for (auto it : adj[node]) {
            if (!vis[it]) {   // If the node has not been visited
                if (dfs(it, adj, vis, pathVis, safe)) {
                    // If a cycle is detected in the DFS subtree
                    return true;
                }
            } else if (pathVis[it]) {
                // If the node is part of the current path (back edge indicating a cycle)
                return true;
            }
        }
        
        pathVis[node] = 0;    // Remove the node from the current path
        safe[node] = 1;       // Mark the node as safe since no cycle was found
        return false;  
    }
    vector<int> eventualSafeNodes(int V, vector<int> adj[]) {
        // code here
        vector<int>result;
        int vis[V] = {0};
        int pathVis[V] = {0};
        int safe[V] = {0};
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,pathVis,safe);
            }
        }
        for(int i=0;i<V;i++){
            if(safe[i]==1){
                result.push_back(i);
            }
        }
        return result;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {

        int V, E;
        cin >> V >> E;
        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        vector<int> safeNodes = obj.eventualSafeNodes(V, adj);
        for (auto i : safeNodes) {
            cout << i << " ";
        }
        cout << endl;
    }
}

// } Driver Code Ends