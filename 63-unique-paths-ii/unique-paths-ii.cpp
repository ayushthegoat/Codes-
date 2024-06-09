class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obs) {
        int n = obs.size();
        int m = obs[0].size();

        if(obs[0][0] == 1 || obs[n-1][m-1] == 1){
            return 0;
        }
        
        vector<vector<int>>ways (n, vector<int>(m , 0));
        queue<pair<int,int>>q;
        q.push({0, 0});
        ways[0][0] = 1;

        const vector<pair<int,int>> directions  = {{1,0},{0,1}};

        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int row = it.first;
            int col = it.second;

            for(const auto &dir : directions) {
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && obs[nrow][ncol] == 0){
                    if(ways[nrow][ncol] == 0) {
                        q.push({nrow, ncol});
                    }

                    ways[nrow][ncol] = ways[nrow][ncol] + ways[row][col]; 
                }
            }
        }

        return ways[n-1][m-1];
    }
};