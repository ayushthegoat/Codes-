class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
  int n = mat.size();
        int m = mat[0].size();

        vector<vector<int>> vis(n,vector<int>(m,0));
        vector<vector<int>> dist(n,vector<int>(m,0));
        queue<pair<pair<int,int>,int>> q;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.push({{i,j},0});
                    vis[i][j] = 1;
                }
            }
        }

        const vector<pair<int,int>> directions = {
            {1,0},{0,1},{-1,0},{0,-1}
        };

        while(!q.empty()){
            int row = q.front().first.first;
            int col = q.front().first.second;
            int steps = q.front().second;
            q.pop();

            dist[row][col] = steps;

            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    vis[nrow][ncol] = 1;
                    q.push({{nrow,ncol}, steps + 1});
                }
            }
        }
        return dist;
    }
};