class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& pre) {
        vector<int>adj[n];  

        for(int i=0;i<pre.size();i++){
            int u = pre[i][0];
            int v = pre[i][1];
            adj[u].push_back(v);
        }

        vector<int>indegree(n,0);
        for(int i=0;i<n;i++){
            for(int it : adj[i]){
                indegree[it]++;
            }
        }

        queue<int>q;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.push(i);
            }
        }

        vector<int>result;
        while(!q.empty()){
            int node = q.front();
            q.pop();
            result.push_back(node);
                 
                 for(auto it : adj[node]){
                    indegree[it]--;

                    if(indegree[it]==0){
                        q.push(it);
                    }
                 }
        }
        if(result.size() != n) return {};
        reverse(result.begin(), result.end());
       return result;
    }
};