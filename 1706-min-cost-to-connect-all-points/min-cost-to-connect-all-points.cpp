class Solution {
public:
 int PrimsAlgo(int V, vector<vector<pair<int,int>>> &adj)
    {
        // code here
        int sum=0;
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>q;
        vector<int>visited(V,0);
        q.push({0,0});
        
        while(!q.empty()){
            auto it = q.top();
            q.pop();
            int node = it.second;
            int weight = it.first;
            
            if(visited[node])continue;
            
            visited[node] = 1;
            sum += weight;
            
            for(const auto &it : adj[node]){
                int adjNode = it.first;
                int adjWeight = it.second;
                if(!visited[adjNode]){
                    q.push({adjWeight, adjNode});
                }
            }
        }
        return sum;
    }
    int minCostConnectPoints(vector<vector<int>>& points) {
        int V = points.size();
        vector<vector<pair<int,int>>>adj(V);
        
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dis = abs(x1-x2) + abs(y1-y2);

                adj[i].push_back({j, dis});
                adj[j].push_back({i, dis});
            }
        }

        return PrimsAlgo(V,adj);
    }
};