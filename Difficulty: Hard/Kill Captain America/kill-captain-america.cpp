//{ Driver Code Starts
#include <bits/stdc++.h>
 
using namespace std;
 

// } Driver Code Ends
class Solution{
public:
    void topo(vector<int>&s , vector<int>adj[], bool vis[], int i) {
        vis[i] = true;
        
        for(auto X : adj[i]) {
            if(!vis[X]){
                topo(s, adj, vis, X);
            }
        }
        s.push_back(i);
        
    }
    void dfs1(vector<int>adj1[], bool vis1[], int i, int &count) {
        vis1[i] = true;
        count++;
        
        for(auto X : adj1[i]) {
            if(!vis1[X]) {
                dfs1(adj1, vis1, X, count);
            }
        }
        
    }
    int captainAmerica(int N, int M, vector<vector<int>> &V){
        // Code Here
        vector<int>adj[N+1];
        int outdegree[N+1] = {0};
        for(int i=0;i<M;i++){
            adj[V[i][0]].push_back(V[i][1]);
            outdegree[V[i][0]]++;
        }
        
        int count = 0;
        for(int i=1;i<=N;i++){
            if(outdegree[i] == 0)count++;
            
        }
        if(count == 1)return 1;
        
        vector<int>s;
        bool vis[N+1] = {false};
        for(int i=1;i<=N;i++){
            if(!vis[i]){
                topo(s, adj, vis, i);
            }
        }
        
        vector<int>adj1[N+1];
        for(int i=0;i<M;i++){
            adj1[V[i][1]].push_back(V[i][0]);
        }
        int ans = 0;
        bool vis1[N+1] = {false};
        int maxx = 0;
        
        for(int i=N-1;i>=0;i--) {
            if(!vis1[s[i]]){
                int count = 0;
                dfs1(adj1, vis1, s[i], count);
                if(count>1){
                    ans+=count;
                }
            }
        }
        return ans;
    } 
};

//{ Driver Code Starts.
 

int main() {
    int t;cin >> t;
    while(t--)
    {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> v(m+1);
        for(int i=0;i<m;i++){
            int a, b;cin >> a >> b;
            v[i].push_back(a);
            v[i].push_back(b);
        }
        
        Solution obj;
        cout << obj.captainAmerica(n, m, v) << endl;
    }
 
}
// } Driver Code Ends