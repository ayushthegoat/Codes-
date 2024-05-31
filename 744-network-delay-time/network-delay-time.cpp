class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {

        vector<vector<pair<int, int>>> adj(n + 1);

        for (const auto& time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj[u].emplace_back(v, w);
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>,
            greater<pair<int, int>>> pq;
        vector<int> res(n + 1, INT_MAX);
        res[k] = 0;
        pq.push({0, k});

        while (!pq.empty()) {
            auto it = pq.top();
            pq.pop();
            int time = it.first;
            int node = it.second;

            for (const auto& it : adj[node]){
                int currAdj = it.first;
                int weight = it.second;

                if(weight + time < res[currAdj]){
                    res[currAdj] = weight + time;
                    pq.push({res[currAdj], currAdj});
                }
            }
        }
       int ret = INT_MIN;
        for (int i = 1; i <= n; i++) {
            if (res[i] == INT_MAX) return -1; // if any node is unreachable
            ret = max(ret, res[i]);
        }
        return ret;
    }
};