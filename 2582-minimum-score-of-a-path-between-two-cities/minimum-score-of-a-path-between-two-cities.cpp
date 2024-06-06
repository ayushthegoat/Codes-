class Solution {
public:
    void dfs(vector<vector<pair<int, int>>> &graph, vector<int> &vis, int node, int &mn) {
        vis[node] = 1;
        
        for (auto neighbours : graph[node]) {
            int val = neighbours.first;
            int weight = neighbours.second;
            mn = min(weight, mn);
            if (!vis[val]) {
                dfs(graph, vis, val, mn);
            }
        }
    }

    int minScore(int n, vector<vector<int>> &roads) {
        // Create an adjacency list
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto &road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];
            graph[u].emplace_back(v, d);
            graph[v].emplace_back(u, d);
        }

        int minVal = INT_MAX;
        vector<int> vis(n + 1, 0);
        
        // Start DFS from node 1
        dfs(graph, vis, 1, minVal);
        
        return minVal;
    }
};