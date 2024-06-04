class Solution {

public:
typedef pair<int, int> vv;

    int minPathSum(vector<vector<int>>& grid) {
        const vector<vv> directions = {{1, 0}, {0, 1}};
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        dist[0][0] = grid[0][0]; 

        priority_queue<pair<int, vv>, vector<pair<int, vv>>,
                       greater<pair<int, vv>>> pq;
        pq.push({grid[0][0], {0, 0}});

        while (!pq.empty()) {
            auto top = pq.top(); 
            pq.pop();

            int currDist = top.first;
            int row = top.second.first;
            int col = top.second.second;

            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    if(currDist + grid[nrow][ncol] < dist[nrow][ncol]){
                        dist[nrow][ncol] = currDist + grid[nrow][ncol];
                        pq.push({dist[nrow][ncol], {nrow, ncol}});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
};