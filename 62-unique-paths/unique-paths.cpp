class Solution {
public:
    int uniquePaths(int n, int m) {
       
        
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

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
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