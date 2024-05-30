//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
	public:
void dfsFill(int node, vector<vector<int>>& adj, stack<int>& sk, vector<bool>& vis) {
    vis[node] = true;
    
    for (auto &it : adj[node]) {
        if (!vis[it]) {
            dfsFill(it, adj, sk, vis);
        }
    }
    
    sk.push(node);
}

void dfsTrav(int node, vector<vector<int>>& adjRev, vector<bool>& vis) {
    vis[node] = true;
    
    for (const auto &neighbour : adjRev[node]) {
        if (!vis[neighbour]) {
            dfsTrav(neighbour, adjRev, vis);
        }
    }
}

// Function to find number of strongly connected components in the graph.
int kosaraju(int V, vector<vector<int>>& adj) {
    stack<int> sk;
    vector<bool> vis(V, false);
    
    // First pass to fill the stack with vertices in the order of their finishing times
    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            dfsFill(i, adj, sk, vis);
        }
    }
    
    // Create a reversed graph
    vector<vector<int>> adjRev(V);
    
    for (int u = 0; u < V; u++) {
        for (auto &v : adj[u]) {
            adjRev[v].push_back(u);
        }
    }
    
    // Second pass to find all SCCs
    int countScc = 0;
    vis.assign(V, false);  // Reset the visited array
    
    while (!sk.empty()) {
        int node = sk.top();
        sk.pop();
        
        if (!vis[node]) {
            dfsTrav(node, adjRev, vis);
            countScc++;
        }
    }
    
    return countScc;
    }

};

//{ Driver Code Starts.


int main()
{
    
    int t;
    cin >> t;
    while(t--)
    {
    	int V, E;
    	cin >> V >> E;

    	vector<vector<int>> adj(V);

    	for(int i = 0; i < E; i++)
    	{
    		int u, v;
    		cin >> u >> v;
    		adj[u].push_back(v);
    	}

    	Solution obj;
    	cout << obj.kosaraju(V, adj) << "\n";
    }

    return 0;
}


// } Driver Code Ends