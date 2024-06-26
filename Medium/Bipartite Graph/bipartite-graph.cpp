//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
private:
bool bfs(vector<int>adj[],int col[],int start,int vertices){
    queue<int>q;
    q.push(start);
    col[start] = 0;
    while(!q.empty()){
        int node = q.front();
        q.pop();
        
        for(const auto& adjacent : adj[node]){
            if(col[adjacent] == -1){
                col[adjacent] = !col[node];
                q.push(adjacent);
            }else if(col[adjacent] == col[node]){
                return false;
            }
        }
        
    }
    return true;
}
public:
	bool isBipartite(int V, vector<int>adj[]){
	    // Code here
	   
	    int col[V];
	    for(int i=0;i<V;i++){
	        col[i] = -1;
	    }
	    for(int i=0;i<V;i++){
	        if(col[i]==-1){
	            if(bfs(adj,col,i,V)==false)return false;
	        }
	    }
	    return true;
	}

	

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}
// } Driver Code Ends