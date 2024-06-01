class Solution {
public:
    void dfs(int node, vector<int>adj[], vector<bool>&vis) {
        vis[node] = true;

        for(auto it : adj[node]){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
    int makeConnected(int n, vector<vector<int>>& connections) {
        int V = connections.size();
        vector<int>adj[n];
         if(V<n-1) return -1;
        for(auto it : connections){
            int it1 = it[0];
            int it2 = it[1];

            adj[it1].push_back(it2);
            adj[it2].push_back(it1);
        }
        vector<bool> vis(n,false);
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                ans++;
            }
        }
        return ans - 1;
    }
};