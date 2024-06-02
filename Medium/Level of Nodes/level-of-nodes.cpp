//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
	public:
	//Function to find the level of node X.
	int nodeLevel(int V, vector<int> adj[], int X) 
	{
	    // code here
	    queue<int>q;
	    int lvl = 0;
	    vector<int>vis(V,0);
	    vis[0] = 1;
	    
	    q.push(0);
	    while(!q.empty()){
	        int size = q.size();
	        while(size--){
	        int node = q.front();
	        q.pop();
	       
	        
	        if(node == X)return lvl;
	        
	        for(const auto &neighbour : adj[node]){
	            if(!vis[neighbour]){
	                vis[neighbour] = 1;
	                q.push(neighbour);
	            }
	        }
	         
	    }
	    lvl++;
	   
	}
	    return -1;
	}
};

//{ Driver Code Starts.


int main()
{
    
    int t;
    cin >> t;
    while(t--)
    {
    	int V, E, X;
    	cin >> V >> E;

    	vector<int> adj[V];

    	for(int i = 0; i < E; i++)
    	{
    		int u, v;
    		cin >> u >> v;
    		adj[u].push_back(v);
    		adj[v].push_back(u);
    	}
    	cin>>X;

    	Solution obj;
    	cout << obj.nodeLevel(V, adj, X) << "\n";
    }

    return 0;
}


// } Driver Code Ends