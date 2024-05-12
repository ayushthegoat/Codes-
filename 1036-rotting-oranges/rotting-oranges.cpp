class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int, int>> rotten;
        int fresh = 0;
        int time = 0;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    rotten.push({i, j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

         static const vector<pair<int, int>> directions = {
                    {-1,0},
             {0,-1},       {0,+1},
                    {+1,0}       
        };

        while(!rotten.empty()){
            int size = rotten.size();
            bool hasFresh = false;

            for(int i=0;i<size;i++){
                int row = rotten.front().first;
                int col = rotten.front().second;
                rotten.pop();


            for (const auto& dir : directions) {
                    int nrow = row + dir.first;
                    int ncol = col + dir.second;
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        fresh--;
                        hasFresh = true;
                        rotten.push({nrow, ncol});
                    }
                }
            }
            if (hasFresh) 
                time++;
            
        }
        return fresh!=0?-1:time;
    }
};